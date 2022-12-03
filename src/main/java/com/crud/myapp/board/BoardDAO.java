package com.crud.myapp.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO { // Data Access object (DAO)
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String BOARD_INSERT = "insert into BOARD (title, writer,content,category) values (?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=?, category=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		return jdbcTemplate.update(BOARD_INSERT,
				new Object[]{vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getCategory()});
	}

	// 글 삭제
	public int deleteBoard(int id) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");

		return jdbcTemplate.update(BOARD_DELETE, new Object[]{id});
	}

	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		return jdbcTemplate.update(BOARD_UPDATE,
				new Object[]{vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getCategory(),vo.getSeq()});
	}

	
	public BoardVO getBoard(int seq) {
		return jdbcTemplate.queryForObject(BOARD_GET,
				new Object[] {seq},
				new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}
	
	public List<BoardVO> getBoardList(){
		return jdbcTemplate.query(BOARD_LIST, new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCategory(rs.getString("category"));
				vo.setRegdate(rs.getDate("regdate"));
				return vo;
			}
		});
	}
}
