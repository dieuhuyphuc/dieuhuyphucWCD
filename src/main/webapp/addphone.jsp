<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    Body {
        font-family: Calibri, Helvetica, sans-serif;
        background-color: pink;
    }
    button {
        background-color: #4CAF50;
        width: 100%;
        color: orange;
        padding: 15px;
        margin: 10px 0px;
        border: none;
        cursor: pointer;
    }
    form {
        border: 3px solid #f1f1f1;
    }
    input[type=text], input[type=password] {
        width: 100%;
        margin: 8px 0;
        padding: 12px 20px;
        display: inline-block;
        border: 2px solid green;
        box-sizing: border-box;
    }
    button:hover {
        opacity: 0.7;
    }
    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        margin: 10px 5px;
    }


    .container {
        padding: 25px;
        background-color: lightblue;
    }
</style>
<body>
<center> <h1> Add Phone </h1> </center>
<form action="Home" method="post">
    <div class="container">
        <label>Name : </label>
        <input type="text"  name="name" required>
        <label>price : </label>
            <input type="text"  name="price" required>
        <label>brand : </label>
        <select name="brand">
            <option value="Apple">Apple</option>
            <option value="Samsung">Samsung</option>
            <option value="xiaomi">Xiaomi</option>
        </select>

        <label>Description : </label>
            <input type="text"  name="description" required>
        <button type="submit">Add</button>
    </div>
</form>
</body>
</html>
