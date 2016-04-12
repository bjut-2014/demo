<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/student.css" rel="stylesheet">
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><a href="index">首页 <span class="sr-only">(current)</span></a></li>
        <li><a href="stu-info">个人信息</a></li>
        <li><a href="weekly-plan">周计划</a></li>
        <li class="active"><a href="practical-reports">实训报告</a></li>
        <li><a href="internship-reports">实习报告</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="reset-pwd">修改密码</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="panel panel-default">
            <div class="panel-body">
                <p><b>标题：</b>${request.onePracticalreport.practicalReportsTitle}</p>
                <p><b>内容：</b></p>
                <p>${request.onePracticalreport.practicalReportsContent}</p>
                <p><b>时间：</b>${request.onePracticalreport.practicalReportsDate}</p>
                <a href="/practical-reports" class="btn btn-primary fr">返回</a>
            </div>
        </div>
    </div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>