<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/templates/taglib.jsp" %>
 <section id="header_area">
        <div class="wrapper header">
            <div class="clearfix header_top">
                <div class="clearfix logo floatleft">
                    <a href="${pageContext.request.contextPath}">
                        <h1><span>C</span>Land</h1>
                    </a>
                </div>
                <div class="clearfix search floatright">
                    <form>
                        <input type="text" placeholder="Search" />
                        <input type="submit" />
                    </form>
                </div>
            </div>
            <div class="header_bottom">
                <nav>
                    <ul id="nav">
                        <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
                        <li id="dropdown"><a href="">Bất động sản</a>
                        	<ul>
                        		<c:if test="${not empty listCat}">
                        			<c:forEach items="${listCat}" var="objCat">
                                		<li><a href="${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug(objCat.cname)}-${objCat.cid}">${objCat.cname}</a></li>
                                	</c:forEach>
                                </c:if>
                            </ul>
                        </li>
                        <!-- <li><a href="single.php">Giới thiệu</a></li> -->
                        <li><a href="${pageContext.request.contextPath}/contact.html">Liên hệ</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </section>