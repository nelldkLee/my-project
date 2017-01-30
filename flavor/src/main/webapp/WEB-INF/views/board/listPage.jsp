
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="form-inline" align="right">
                
                <div class="form-group">
                    <select class="form-control">
                        <option value="n" <c:out value="${cri.searchType == null ? 'selected' : ''}"/>>---</option>
                        <option value="t" <c:out value="${cri.searchType eq 't' ? 'selected' : ''}"/>>Title</option>
                        <option value="c" <c:out value="${cri.searchType eq 'c' ? 'selected' : ''}"/>>Content</option>
                        <option value="w" <c:out value="${cri.searchType eq 'w' ? 'selected' : ''}"/>>Writer</option>
                        <option value="tc" <c:out value="${cri.searchType eq 'tc' ? 'selected' : ''}"/>>Title OR Content</option>
                        <option value="cw" <c:out value="${cri.searchType eq 'cw' ? 'selected' : ''}"/>>Content OR Writer</option>
                        <option value="tcw" <c:out value="${cri.searchType eq 'tcw' ? 'selected' : ''}"/>>Title OR Content OR Writer</option>
                    </select>
                    <input type="text" class="form-control" name="keyword" id="keywordInput" value="${cri.keyword}"/>
                    <button class="btn btn-info">Search</button>
                </div>
            </div>
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px;">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px;">VIEWCNT</th>
						</tr>

						<c:forEach items="${list}" var="boardVO">

							<tr>
								<td>${boardVO.bno}</td>
								<td><a href='/board/readPage?bno=${boardVO.bno}'>${boardVO.title}</a></td>
								<td>${boardVO.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${boardVO.regdate}" /></td>
								<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
							</tr>

						</c:forEach>
					</table>
				</div>
				<div class="box-footer">
				    <div class="text-center">
				    	<ul class="pagination">
				    		<c:if test="${pageMaker.prev }">
				    			<li><a href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1) }" >&laquo;</a></li>
				    		</c:if>
				    		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				    			<li <c:out value="${pageMaker.cri.page == idx ? 'class=active' : ''}"/>>
				    				<a href="listPage${pageMaker.makeQuery(idx) }">${idx}</a>
				    			</li>
				    		</c:forEach>
				    		<c:if test="${pageMaker.next }">
				    			<li><a href="listPage${pageMaker.makeQuery(pageMaker.endPage + 1) }">&raquo;</a></li>
				    		</c:if>
				    	</ul>
				    
				    </div>
				    <div class="text-right">
				    <button type="submit" class="btn btn-danger" >글쓰기</button>
				    </div>
				</div>
			</div>
		</div>
	</div>
</section>
</div>

<script>
	var result = '${msg}';
	if (result == 'success') {
		alert("처리가 완료되었습니다.");
	}
	
	
	$(document).ready(function(){
		$(".btn-danger").on("click", function() {
			self.location = "/board/register"
		});
	});
	
	$(".btn-info").on("click", function(event){
		self.location = "listPage" + "${pageMaker.makeQuery(1)}" + "&searchType=" + $("select option:selected").val() + "&keyword=" + $("#keywordInput").val();
	});
	
</script>

<%@include file="../include/footer.jsp"%>