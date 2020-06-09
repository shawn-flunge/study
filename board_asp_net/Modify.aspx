<%@ Page Language="C#" %>
<%@ Import Namespace="System.Data.SqlClient" %>
<!DOCTYPE html>

<script runat="server">

    protected void Page_Load(object sender, EventArgs e)
    {
        if(!IsPostBack)
        {
            SqlConnection con = new SqlConnection("Data Source=.\\SQLEXPRESS; Initial Catalog=MyDB; Integrated Security=False; uid=flunge; pwd=dksk1399");
            con.Open();

            string sql = "select * from tblReBoard where num=" + Request["No"];
            SqlCommand cmd = new SqlCommand(sql, con);

            SqlDataReader rd = cmd.ExecuteReader();

            if (rd.Read())
            {
                lblName.Text = rd["name"].ToString();
                txtTitle.Text = rd["title"].ToString();
                txtContents.Text = rd["contents"].ToString();

            }
            rd.Close();
            con.Close();

        }
    }

    protected void btnReset_Click(object sender, EventArgs e)
    {
        Response.Redirect("List.aspx");
    }

    protected void btnWrite_Click(object sender, EventArgs e)
    {
        SqlConnection con = new SqlConnection("Data Source=.\\SQLEXPRESS; Initial Catalog=MyDB; Integrated Security=False; uid=flunge; pwd=dksk1399");
        con.Open();

        string sql = "update tblReBoard set title='" + txtTitle.Text + "', contents='" + txtContents.Text + "' where num=" + Request["No"];
        SqlCommand cmd = new SqlCommand(sql, con);
        cmd.ExecuteNonQuery();
        con.Close();
        Response.Redirect("List.aspx");
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

            <table style="width:50%">
                <tr>
                    <td colspan="2" style="text-align:center;"><h3>게시판 수정하기</h3></td>
                </tr>
                <tr>
                    <td style="height:50px;width:100px; background-color:gray;">작성자</td>
                    <td>
                        <%--<asp:TextBox ID="txtName" runat="server" Width="100%"></asp:TextBox>--%>
                        <asp:Label ID="lblName" runat="server" Text="" Width="100%"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><hr /></td>
                </tr>
                <tr>
                    <td style="height:50px;width:100px; background-color:gray;">글 제목</td>
                    <td>
                        <asp:TextBox ID="txtTitle" runat="server" Width="100%"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td style="height:50px;width:100px; background-color:gray;">글 내용</td>
                    <td >
     
                        <asp:TextBox ID="txtContents" runat="server"  TextMode="MultiLine" style="width:100%; height:200px;"     ></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:right;">
                        <asp:Button ID="btnReset" runat="server" Text="수정취소" OnClick="btnReset_Click"/>
                        <asp:Button ID="btnWrite" runat="server" Text="게시물 수정" OnClick="btnWrite_Click"/>
                    </td>
                </tr>
            </table>

        </div>
    </form>
</body>
</html>
