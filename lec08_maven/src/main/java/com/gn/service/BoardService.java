package com.gn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dao.BoardDao;
import com.gn.dto.Attach;
import com.gn.dto.Board;

public class BoardService {
	private BoardDao boardDao = new BoardDao();
	
	public List<Board> selectBoardList(Board param){
		return boardDao.selectBoardList(param);
	}
	
	public int selectBoardCount(Board param) {
		return boardDao.selectBoardCount(param);
	}
	
	public Board selectBoardOne(int boardNo) {
		return boardDao.selectBoardOne(boardNo);
	}
	
	public Attach selectAttachByBoardNo(int boardNo) {
		return boardDao.selectAttachByBoardNo(boardNo);
	}
	
	public Attach selectAttachByAttachNo(int attachNo) {
		return boardDao.selectAttachByAttachNo(attachNo);
	}
	
	
	
	// 게시글 + 파일 트랜젝션 처리
	// 여기서 Sql 세션을 생성
	public int createBoardWithAttach(Board board, Attach attach) {
		// 지정한 순간에 커밋할 수 있게 매개값을 false로 선언
		SqlSession session = SqlSessionTemplate.getSqlSession(false);
		int result = 0;
		
		try {
			// 1. 게시글 등록
			result = boardDao.insertBoard(session, board);
			
			// 파일정보가 있고 게시글 등록이 성공한 경우
			if(attach != null && result > 0) {
				// 2. 파일 정보 등록 
				attach.setBoardNo(board.getBoardNo());
				result = boardDao.insertAttach(session, attach);
			}
			
			// 3. commit 또는 rollback
			if(result > 0) {
				session.commit();
			} else { 
				session.rollback();
			}
		} catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}


}
