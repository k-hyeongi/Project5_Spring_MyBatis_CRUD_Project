package com.crud.myapp.board;

import org.springframework.beans.factory.annotation.Autowired;
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
//	public void setJdbcjdbcTemplate(JdbcjdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

//	private final String BOARD_INSERT = "insert into BOARD (title, writer,content,category) values (?,?,?,?)";
//	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=?, category=? where seq=?";
//	private final String BOARD_DELETE = "delete from BOARD where seq=?";
//	private final String BOARD_GET = "select * from BOARD  where seq=?";
//	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		String sql = "insert into BOARD (category, title, writer, content) values ("
			+ "'" + vo.getTitle() + "',"
			+ "'" + vo.getWriter() + "',"
			+ "'" + vo.getContent() + "',"
			+ "'" + vo.getCategory() + "')";
		return jdbcTemplate.update(sql);
//		return jdbcTemplate.update(BOARD_INSERT, new
//				Object[]{vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getCategory()});
	}

	// 글 삭제
	public int deleteBoard(int id) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		String sql = "delete from BOARD  where seq= " + id;
		return jdbcTemplate.update(sql);
//		return jdbcTemplate.update(BOARD_DELETE,
//				new Object[]{id});
	}

	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		String sql = "update BOARD set "
			+ "title='" + vo.getTitle() + "',"
			+ "writer='" + vo.getWriter() + "',"
			+ "content='" + vo.getContent() + "',"
			+ "category='" + vo.getCategory() + "' "
			+ "where seq=" + vo.getSeq();
		return jdbcTemplate.update(sql);
//		return jdbcTemplate.update(BOARD_UPDATE,
//				new Object[]{vo.getTitle(),vo.getWriter(),vo.getContent(),vo.getCategory(),vo.getSeq()});
	}

	class BoardRowMapper implements RowMapper<BoardVO> {
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
	}
	
	public BoardVO getBoard(int seq) {
		String sql = "select * from BOARD where seq=" + seq;
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
//		return jdbcTemplate.queryForObject(BOARD_GET,
//				new Object[] {seq},
//				new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}
	
	public List<BoardVO> getBoardList(){
		String sql = "select * from BOARD order by regdate desc";
		return jdbcTemplate.query(sql, new BoardRowMapper());
//		return jdbcTemplate.query(BOARD_LIST, new RowMapper<BoardVO>() {
//			@Override
//			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				BoardVO vo = new BoardVO();
//				vo.setSeq(rs.getInt("seq"));
//				vo.setTitle(rs.getString("title"));
//				vo.setContent(rs.getString("content"));
//				vo.setWriter(rs.getString("writer"));
//				vo.setCategory(rs.getString("category"));
//				vo.setRegdate(rs.getDate("regdate"));
//				return vo;
//			}
//		});
	}
}
