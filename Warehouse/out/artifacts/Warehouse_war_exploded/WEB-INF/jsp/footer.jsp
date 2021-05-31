<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="list-page">
    <a id="front" href="#" onclick="front()">上一页</a>
    <span id="length">${length}</span> 条
    <span id="currentpage">${currentpage}</span>/
    <span id="pagecount">${pagecount}</span> 页
    <a id="late" href="#" onclick="late()">下一页</a>
    <script>
        function front() {
            if(Number(document.querySelector("#currentpage").innerText)-1 <= 0)
                return;
            let currentpage =Number(document.querySelector("#currentpage").innerText)-1;
            let select = document.getElementById("selected");
            let type = select.options[select.selectedIndex].value;
            let keyword = document.getElementById("keyword").value;
            document.getElementById("front").setAttribute("href","${pageContext.request.contextPath}/searchcustomer?type="+type+"&keyword="+keyword+"&currentpage="+currentpage);
            document.getElementById("front").click();
        }
        function late() {
            if(Number(document.querySelector("#currentpage").innerText)+1 > Number(document.querySelector("#pagecount").innerText))
                return;
            let currentpage = Number(document.querySelector("#currentpage").innerText)+1;
            let select = document.getElementById("selected");
            let type = select.options[select.selectedIndex].value;
            let keyword = document.getElementById("keyword").value;
            document.getElementById("late").setAttribute("href","${pageContext.request.contextPath}/searchcustomer?type="+type+"&keyword="+keyword+"&currentpage="+currentpage);
            document.getElementById("late").click();
        }
    </script>
</div>
