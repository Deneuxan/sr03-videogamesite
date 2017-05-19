<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Bootstrap 101 Template</title>
<link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<!-- <p><code>&lt;header&gt;</code> 作为内联元素被包围。</p>
<p>如果需要把代码显示为一个独立的块元素，请使用 &lt;pre&gt; 标签：</p>
<pre class="pre-scrollable">
&lt;article&gt;
	&lt;h1&gt;Article Heading&lt;/h1&gt;
&lt;/article&gt;
</pre> -->
 
 <table class="table table-bordered table-striped table-hover">
	<caption>基本的表格布局</caption>
   <thead>
      <tr>
         <th>名称</th>
         <th>城市</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>Tanmay</td>
         <td>Bangalore</td>
      </tr>
      <tr>
         <td>Sachin</td>
         <td>Mumbai</td>
      </tr>
   </tbody>
</table>

<!-- 根据不同颜色 -->
<table class="table table-responsive">
  <caption>上下文表格布局</caption>
  <thead>
    <tr>
      <th>产品</th>
      <th>付款日期</th>
      <th>状态</th></tr>
  </thead>
  <tbody>
    <tr class="active">
      <td>产品1</td>
      <td>23/11/2013</td>
      <td>待发货</td></tr>
    <tr class="success">
      <td>产品2</td>
      <td>10/11/2013</td>
      <td>发货中</td></tr>
    <tr class="warning">
      <td>产品3</td>
      <td>20/10/2013</td>
      <td>待确认</td></tr>
    <tr class="danger">
      <td>产品4</td>
      <td>20/10/2013</td>
      <td>已退货</td></tr>
  </tbody>
</table>

<form role="form">
	<div class="form-group">
		<label for="name">名称</label>
		<input type="text" class="form-control" id="name" 
			   placeholder="请输入名称">
	</div>
	<div class="form-group">
		<label for="inputfile">文件输入</label>
		<input type="file" id="inputfile">
		<p class="help-block">这里是块级帮助文本的实例。</p>
	</div>
	<div class="checkbox">
		<label>
			<input type="checkbox"> 请打勾
		</label>
	</div>
	<button type="submit" class="btn btn-default">提交</button>
</form>

      <script src="../bootstrap-3.3.7-dist/js/jquery.min.js"></script>

      <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>
