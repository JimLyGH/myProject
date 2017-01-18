require("luacom");
require("lc");


local name = 'E://' ..  lc.a2u("����") .. '.xls';

--����excel����
local excel = luacom.CreateObject("Excel.Application"); --�����µ�ʵ��

excel.Visible = false;

local book =excel.Workbooks:Add();

--����һ��������
local sheet = book.Sheets(1); 

sheet.Cells(1, 1).Value2 = "hello";
sheet.Cells(1, 2).Value2 = lc.a2u("���");

sheet.Cells(2, 1).Value2 = "hello";
sheet.Cells(2, 2).Value2 = "java";

local style = sheet:Range("A1:B1");
--��A1��B1�н��мӴ�
style.Font.Bold=true;
--���������С
style.Font.size = 30;

--���õ�һ�е��и�
sheet.Rows(1).RowHeight = 50;

--�����п�
for i = 1, 2, 1 do
    sheet.Columns(i).ColumnWidth = 30;
end

-- ����
book:SaveAs(name);

book:Close();

--[[ �ر�excel -------------]]
excel:Quit();

--�ͷ���Դ
excel = nil;

collectgarbage();