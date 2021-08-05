package co.pooh.prj.image.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.pooh.prj.comm.DataSource;
import co.pooh.prj.image.vo.FileInformationVO;

public class FileInfoService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private FileInfoMapper map = sqlSession.getMapper(FileInfoMapper.class);
	
	public List<FileInformationVO> fileSelectList() {
		return map.fileSelectList();
	}
	
	public FileInformationVO fileSelect(int key) {
		return map.fileSelect(key);
	}
	
	public int FileInsert(FileInformationVO vo) {
		return map.FileInsert(vo);
	}
	
	public int FileUpdate(int key) {
		return map.FileUpdate(key);
	}
	
	public int FileDelete(FileInformationVO vo) {
		return map.FileDelete(vo);
	}
}
