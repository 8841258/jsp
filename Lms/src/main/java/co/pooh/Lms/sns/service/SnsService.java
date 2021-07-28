package co.pooh.Lms.sns.service;

import java.util.List;

import co.pooh.Lms.sns.vo.CommentsVO;
import co.pooh.Lms.sns.vo.SnsVO;

public interface SnsService {
	List<SnsVO> snsSelectList();
	
	//상속되어 있음
	List<SnsVO> snsSelect(int no);

	int snsInsert(SnsVO vo);
	
	int commentsInsert(CommentsVO vo);
	
	int snsUpdate(SnsVO vo);
	
	int commentsUpdate(CommentsVO vo);
	
	int snsDelete(SnsVO vo);
	
	int commentsDelete(CommentsVO vo);
	
	
}
