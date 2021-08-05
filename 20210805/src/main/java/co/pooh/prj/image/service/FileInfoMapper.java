package co.pooh.prj.image.service;

import java.util.List;

import co.pooh.prj.image.vo.FileInformationVO;

public interface FileInfoMapper {
	List<FileInformationVO> fileSelectList();
	
	FileInformationVO fileSelect(int key);
	
	int FileInsert(FileInformationVO vo);
	
	int FileUpdate(int key);
	
	int FileDelete(FileInformationVO vo);
}
