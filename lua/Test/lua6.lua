require("luacom");
require("lc");


local name = 'E://' ..  lc.a2u("福建") .. '.xls';

--创建excel对象
local excel = luacom.CreateObject("Excel.Application"); --创建新的实例

excel.Visible = false;

local book =excel.Workbooks:Add();

--读第一个工作表
local sheet = book.Sheets(1); 

sheet.Cells(1, 1).Value2 = "hello";
sheet.Cells(1, 2).Value2 = lc.a2u("你好");

sheet.Cells(2, 1).Value2 = "hello";
sheet.Cells(2, 2).Value2 = "java";

local style = sheet:Range("A1:B1");
--对A1至B1列进行加粗
style.Font.Bold=true;
--设置字体大小
style.Font.size = 30;

--设置第一行的行高
sheet.Rows(1).RowHeight = 50;

--设置列宽
for i = 1, 2, 1 do
    sheet.Columns(i).ColumnWidth = 30;
end

-- 保存
book:SaveAs(name);

book:Close();

--[[ 关闭excel -------------]]
excel:Quit();

--释放资源
excel = nil;

collectgarbage();