<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h4>Main page</h4>
<form action="/insert" method="post">
    <div class="container">
        <label>Insert client: </label>
        <input type="text" placeholder="first name" name="firstname">
        <input type="text" placeholder="last name" name="lastname">
        <input type="text" placeholder="phone number" name="phonenumber">
        <input type="text" placeholder="e-mail" name="email">
        <input type="text" placeholder="address" name="address">
        <button type="submit">Insert</button>
    </div>
</form>
<form action="/select" method="post">
    <div class="container">
        <label>Select client by id: </label>
        <input type="text" placeholder="сlient id" name="selectid">
        <button type="submit">Select</button>
    </div>
</form>
</form>
<p><a href="/select">Select all clients</a></p>
<form action="/update" method="post">
    <div class="container">
        <label>Update client: </label>
        <input type="text" placeholder="client id" name="updateid">
        <input type="text" placeholder="first name" name="firstname">
        <input type="text" placeholder="last name" name="lastname">
        <input type="text" placeholder="phone number" name="phonenumber">
        <input type="text" placeholder="e-mail" name="email">
        <input type="text" placeholder="address" name="address">
        <button type="submit">Update</button>
    </div>
</form>
<form action="/delete" method="post">
    <div class="container">
        <label id="deleteid">Delete client by id: </label>
        <input type="text" placeholder="сlient id" name="deleteid">
        <button type="submit">Delete</button>
    </div>
</form>
<p><a href="/delete">Delete all clients</a></p>
</body>
</html>
