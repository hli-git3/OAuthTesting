<%--
  Created by IntelliJ IDEA.
  User: hli
  Date: 9/8/13
  Time: 2:40 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
  <h3>Hello, ${info.display_name}. You are logged in through dropbox.</h3>

<div>
  Your dropbox quota:  <br/>
  <ul>
      <li>Shared: ${info.quota_info.shared}</li>
  </ul>


</div>

</body>
</html>