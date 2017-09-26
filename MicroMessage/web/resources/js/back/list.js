/**
 *后台调用批量删除操作
 */
function deleteBatch(basePath) {
    $("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
    $("#mainForm").submit();
}
function insertOne(basePath) {
    $("#mainForm").attr("action",basePath+"AddPageServlet.action");
    $("#mainForm").submit();
}