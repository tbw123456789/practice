<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- #section:basics/sidebar -->
<div id="sidebar" class="sidebar responsive">
	<ul class="nav nav-list">
		<li class="active" name="li"><a href="#"> <i
				class="menu-icon fa fa-desktop"></i> <span class="menu-text">排班公告</span></a>
			<b class="arrow"></b></li>
		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa glyphicon-user fa-home">

		</i>
			<span
				class="menu-text">手术间排班</span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li class="" name="li">
					<a
					href="<%=request.getContextPath()%>/commandController/paibanA.do"
					target="mainFrame" class="menu-text"> <i
						class="menu-icon fa fa-caret-right"></i> <span>今日排班</span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b></li>
				<li class="" name="li"><a
					href="<%=request.getContextPath()%>/commandController/paibanPZ.do"
					target="mainFrame" class="menu-text"> <i
						class="menu-icon fa fa-caret-right"></i> <span>排班配置</span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b></li>
			</ul></li>
	</ul>

	<ul class="nav nav-list">
		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa glyphicon-user fa-home"></i> <span
				class="menu-text">家属公告栏</span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li class="" name="li"><a
					href="<%=request.getContextPath()%>/commandController/jiashuA.do"
					target="mainFrame" class="menu-text"> <i
						class="menu-icon fa fa-caret-right"></i> <span>家属信息</span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b></li>
				<li class="" name="li"><a
					href="<%=request.getContextPath()%>/commandController/jiashuPZ.do"
					target="mainFrame" class="menu-text"> <i
						class="menu-icon fa fa-caret-right"></i> <span>公告设置</span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b></li>
			</ul></li>
	</ul>



	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
	<!-- /section:basics/sidebar.layout.minimize -->
	<script type="text/javascript">try {
          ace.settings.check('sidebar', 'collapsed')
        } catch(e) {}</script>
	<script type="text/javascript">window.onload = function() {
          var aLi = document.getElementsByName("li");
          var i = 0;
          for (i = 0; i < aLi.length; i++) {
            aLi[i].onclick = function() {
              var Li = document.getElementsByName("li");
              for (i = 0; i < Li.length; i++) {
                if (Li[i].className == "active") {
                  Li[i].className = "";
                }
              }
              this.className = "active";
            };
          }
        };</script>
</div>