<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="paging">
             <a href="/maincate.do?maincate=fragrances&page=1">처음</a>
             &nbsp;&nbsp;
             <a href="/maincate.do?maincate=fragrances&page=${paging.prevPageGroup}">&lt;&lt;</a>
             &nbsp;&nbsp;
             <a href="/maincate.do?maincate=fragrances&page=${paging.prevPage}">&lt;</a>
             &nbsp;&nbsp;
             <c:forEach begin="${paging.firstPageOfGroup }" end="${paging.endPageOfGroup }" var="i"> 
				<c:choose>  
					<c:when test="${paging.page eq i}"> 
	    				<strong>${i}</strong>
					</c:when> 
					<c:otherwise>
	    				<a href="/maincate.do?maincate=fragrances&page=${i}">${i}</a>
					</c:otherwise> 
				</c:choose>
 			</c:forEach>
 			&nbsp;&nbsp;
             <a href="/maincate.do?maincate=fragrances&page=${paging.nextPage}">&gt;</a>
 			&nbsp;&nbsp;
             <a href="/maincate.do?maincate=fragrances&page=${paging.nextPageGroup}">&gt;&gt;</a>
 			&nbsp;&nbsp;
             <a href="/maincate.do?maincate=fragrances&page=${paging.maxPage}">끝</a>
</div>