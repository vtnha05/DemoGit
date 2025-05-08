<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bài 5 lab1</title>
</head>
<body>
 <h1>Rectangle Calculator</h1>
    
    <!-- Form nhập liệu -->
    <form action="HCN" method="post">
        <label for="length">Length:</label>
        <input type="number" id="length" name="length" step="0.01" required><br>

        <label for="width">Width:</label>
        <input type="number" id="width" name="width" step="0.01" required><br>

        <button type="submit">Calculate</button>
    </form>

    <!-- Hiển thị kết quả -->
    <c:if test="${not empty area}">
        <h2>Results:</h2>
        <p>Area: ${area}</p>
        <p>Perimeter: ${perimeter}</p>
    </c:if>

    <!-- Hiển thị lỗi nếu có -->
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
</body>
</html>