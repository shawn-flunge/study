<%@ Page Language="C#" %>

<!DOCTYPE html>

<script runat="server">

    string sql = "SELECT [num], [name], [title], [writedate], [readcount],[depth], [refer], [pos] FROM [tblReBoard] ORDER BY [refer] DESC, [pos]";

    private void ListDisplay()
    {
        SqlDataSource1.SelectCommand = sql;
    }
    protected void Page_Load(object sender, EventArgs e)
    {
        ListDisplay();
    }

    protected void btnWrite_Click(object sender, EventArgs e)
    {
        Response.Redirect("write.aspx?Action=Write");
    }
    public string SetSpace(int depth)
    {
        if (depth == 0) return "";
        string strSpace = "";
        for (int i = 0; i < depth; i++)
            strSpace += "&nbsp;&nbsp;&nbsp;";
        return strSpace;
    }
</script>


<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3 style="text-align:center">게시판</h3><hr />
            
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataKeyNames="num" DataSourceID="SqlDataSource1" >
                <Columns>
                    <asp:BoundField DataField="num" HeaderText="no." InsertVisible="False" ReadOnly="True" SortExpression="num">
                        <HeaderStyle Width="30px" />
                    </asp:BoundField>
                                                    
                    <asp:TemplateField HeaderText="제목">
                        <ItemTemplate>
                            <%# SetSpace((int)Eval("depth")) %>
                            <a href="<%# "View.aspx?No="+Eval("num") %>"> <%# Eval("title") %></a>
                        </ItemTemplate>
                        <HeaderStyle Width="250px" />
                    </asp:TemplateField>
                    
                    <asp:BoundField DataField="name" HeaderText="이름" SortExpression="name" >
                        <HeaderStyle Width="80px" />
                     </asp:BoundField>
                    <asp:BoundField DataField="writedate" HeaderText="올린날짜" SortExpression="writedate"  >
                        <HeaderStyle Width="100px" />
                    </asp:BoundField>
                    <asp:BoundField DataField="readcount" HeaderText="조회수" SortExpression="readcount" >
                        <HeaderStyle Width="60px" />
                    </asp:BoundField>
                </Columns>
                <FooterStyle BackColor="#CCCCCC" ForeColor="Black" />
                <PagerStyle BackColor="#999999" ForeColor="Black" HorizontalAlign="Center" />
                <SelectedRowStyle BackColor="#008A8C" Font-Bold="true" ForeColor="White" />
                <HeaderStyle BackColor="#000084" Font-Bold="true" ForeColor="White" />
                <AlternatingRowStyle BackColor="#DCDCDC" />
            </asp:GridView>

            <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:MyDBConnectionString %>" SelectCommand="SELECT [num], [name], [title], [writedate], [readcount],[depth], [refer], [pos] FROM [tblReBoard] ORDER BY [refer] DESC, [pos]"></asp:SqlDataSource>
           <hr />
        <%--    <asp:DropDownList ID="DropDownList1" runat="server"></asp:DropDownList>
            <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
            <asp:Button ID="Button1" runat="server" Text="글쓰기" OnClick="btnWrite_Click"/>--%>


            <asp:Button ID="btnWrite" runat="server" Text="글쓰기" OnClick="btnWrite_Click"/>
            

        </div>
    </form>
</body>
</html>
