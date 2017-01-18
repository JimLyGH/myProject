require("luacom");
require("lc");

local name = 'E://' ..  lc.a2u("����EXCEL����") .. '.xls';

--����excel����
local excel = luacom.CreateObject("Excel.Application"); --�����µ�ʵ��

excel.Visible = false;

local book =excel.Workbooks:Add();

--����һ��������
local sheet = book.Sheets(1); 

sheet.Cells(1, 1).Value2 = "hello";
sheet.Cells(1, 2).Value2 = lc.a2u("���");
for i=3, 10, 1 do
  sheet.Cells(1, i).Value2 = "hello" .. i;	
end

sheet.Cells(2, 1).Value2 = "hello";
sheet.Cells(2, 2).Value2 = "java";
for i=3, 10, 1 do
  sheet.Cells(2, i).Value2 = "work" .. i;	
end

for i=1, 10, 1 do
  sheet.Cells(7, i).Value2 = i;	
  sheet.Cells(8, i).Value2 = 100 + i;
end

--��ʽ
sheet.Cells(9,1).Formula = '=A7+A8' 
--��ʽ R��ʾ��C��ʾ�� R8C2��ʾ��8�е�2��
sheet.Cells(9,2).FormulaR1C1 = '=R8C2+R7C2' 
--�����ı���ɫ
sheet.Cells(1,1).Font.Color = 0x0000ff;

local style = sheet:Range("A1:B1");
--��A1��B1�н��мӴ�
style.Font.Bold=true;
--���������С
style.Font.size = 30;

--�ϲ���Ԫ��
sheet:Range('D3:D6'):Merge();
--���в���
sheet.Cells(4,5).EntireRow.Interior.Color = 0x334455   
--���в���
sheet.Cells(4,5).EntireColumn.Interior.Color = 0x998877 

local cell = sheet.Cells(7,1)
cell.Font.Strikethrough = true  --ɾ����
cell.font.OutlineFont = true    --�»���
--�����ı�����
cell.Font.Name = 'Arial'
--cell.Font.Shadow = true
--cell.Font.SuperScript = true
--cell.Font.SubScript = true

--������ɫ����A8��C8��ɫ
local range = sheet:Range('A8:C8')
range.Interior.Color = 0x778899 
--�߿���ʽ --ÿ��С���ڱ߿�
range.Borders.LineStyle = 1 

--��߿�
sheet:Range('C2:G7').BorderAround(1)
--�߿���
range.Borders.Weight = 4      
--������
range.Interior.Pattern = 8

--ͳ�Ƶ�Ԫ����
print(range.Cells.Count)    
print(range.Rows.Count)
print(range.Columns.Count)
--��ʽ������
range.NumberFormat = '$#,##0.00'
--����
--sheet:Range('A9'):Cut()   
--����
sheet:Range('A9'):Copy()    
--ճ��
sheet:Paste(sheet:Range('A10')) 
--book.Worksheets('sheet3'):Delete()

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