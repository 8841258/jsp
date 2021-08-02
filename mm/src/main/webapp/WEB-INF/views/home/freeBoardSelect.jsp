<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<!-- 여기에 게시판 1개 글 보기 틀 만들기<br>
글 관련 데이터 뜨는지 확인 >>>>>>>>
${board[0].freeTitle } : ${board[0].freeDate } : ${board[0].freeWriter } : ${board[0].freeContent } : ${board[0].freeCnum }
<br>
댓글 관련 데이터 뜨는지 확인 >>>>>>>> 
<c:forEach var="board" items="${board }">
${board.freeCwriter } : ${board.freeCcontent } : ${board.freeCdate }<br>
</c:forEach> -->

<div class="container-fluid  dashboard-content">
   <div class="row">
      <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
         <div class="page-header">
            <h2 class="pageheader-title">자유 게시판</h2>
            <p class="pageheader-text">
               여러분이 하고 싶은 말을 자유롭게 남겨주세요!<br>욕설 및 비방성 게시글은 삼가주세요.
            </p>
         </div>
      </div>
   </div>
   <div class="row">
      <!-- ============================================================== -->
      <!-- basic table -->
      <!-- ============================================================== -->
      <div class="col-12">
         <div class="card">
            <h5 class="card-header">
               <span class="from">${board[0].freeTitle }</span>
            </h5>
            <div class="card-body">
               <div>
                  <div align="right">${board[0].freeDate },
                     ${board[0].freeWriter }&nbsp;&nbsp;&nbsp;&nbsp;<i
                        class="far fa-comment-alt"></i>&nbsp;${board[0].freeCnum }
                     &nbsp;&nbsp;<i class="fas fa-eye"></i>&nbsp;${board[0].hit }
                  </div>

               </div>
               <div class="mt-3">${fn:replace(board[0].freeContent, replaceChar, "<br/>") }</div>
            </div>
         </div>
      </div>
   </div>
   <div class="row">
      <div class="col-sm-4">
         <button type="button" onclick="location.href='freeBoardList.do'"
            class="btn btn-secondary btn-sm">
            <i class="fas fa-list-ul"></i>&nbsp;&nbsp;목록
         </button>
      </div>
      <div class="col-sm-8 mb-4" align="right">

         <c:if test="${ member.nickname eq board[0].freeWriter }">
            <button type="button"
               onclick="location.href='freeBoardUpdateForm.do?freeno=${board[0].freeNo}'"
               class="btn btn-secondary btn-sm">
               <i class="fas fa-edit"></i>&nbsp;&nbsp;수정
            </button>
            <button type="button"
               onclick="location.href='freeBoardDelete.do?freeno=${board[0].freeNo}'"
               class="btn btn-secondary btn-sm">
               <i class="fas fa-trash-alt"></i>&nbsp;&nbsp;삭제
            </button>
         </c:if>

         <button type="button"
            onclick="location.href='freeBoardInsertForm.do'"
            class="btn btn-secondary btn-sm">
            <i class="fas fa-pencil-alt"></i>&nbsp;&nbsp;글쓰기
         </button>
      </div>
   </div>







   <div class="row">
      <div class="col-12">
         <div class="card">
            <c:forEach var="board" items="${board }">
               <div class="card-body border-bottom">
                  <div class="row">
                     <div class="col-sm-6">
                        <span class="lead">${board.freeCwriter }</span>&nbsp;&nbsp;<span
                           class="small">${board.freeCdate }</span>
                     </div>
                     <c:if test="${ member.nickname eq board.freeCwriter }">
                        <div class="col-sm-6" align="right"
                           onclick="location.href='freeCommentDelete.do?&freecno=${board.freeCno}&freeno=${board.freeNo }'">삭제</div>
                     </c:if>
                  </div>
                  <br>
                  <div class="mt-2">${board.freeCcontent }</div>
               </div>
            </c:forEach>
         </div>
         <div class="row">
            <div class="card-body">
               <form action="freeBoardCommentInsert.do">
                  <textarea class="form-control mb-3" name="freeccontent"
                     placeholder="댓글을 입력하세요" rows="4"></textarea>
                  <input type="hidden" name="freeno" value="${board[0].freeNo}">
                  <div>
                     <button type="submit" class="btn btn-secondary">댓글 쓰기</button>
                  </div>
               </form>
            </div>
         </div>
      </div>
   </div>


</div>


<div class="email-list-item email-list-item--unread">
   <div class="email-list-actions">
      <label class="custom-control custom-checkbox"> <input
         class="custom-control-input checkboxes" type="checkbox" value="1"
         id="one"><span class="custom-control-label"></span>
      </label><a class="favorite active" href="#"><span><i
            class="fas fa-star"></i></span></a>
   </div>
   <div class="email-list-detail">
      <span class="date float-right"><span class="icon"><i
            class="fas fa-paperclip"></i> </span>28 Jul</span><span class="from">Penelope
         Thornton</span>
      <p class="msg">Urgent - You forgot your keys in the class room,
         please come imediatly!</p>
   </div>
</div>

</div>