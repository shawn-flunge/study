<%@ Page Language="C#" %>
<%@ Import Namespace="System.Data.SqlClient" %>
<!DOCTYPE html>

<script runat="server">

    protected void Button2_Click(object sender, EventArgs e)
    {
        Response.Redirect("List.aspx");
    }

    protected void btnPass_Click(object sender, EventArgs e)
    {
        SqlConnection con = new SqlConnection("Data Source=.\\SQLEXPRESS; Initial Catalog=MyDB; Integrated Security=False; uid=flunge; pwd=dksk1399");
        con.Open();

        string sql = "select * from tblReBoard where num=" + Request["No"];
        SqlCommand cmd = new SqlCommand(sql, con);
        SqlDataReader rd = cmd.ExecuteReader();

        string strPass;
        rd.Read();
        strPass = rd["pwd"].ToString();
        rd.Close();

        if(strPass.CompareTo(txtPass.Text)==0 && Request["Action"].CompareTo("Modify") == 0)
        {
            Response.Redirect("Modify.aspx?No=" + Request["No"]);
        }
        if(strPass.CompareTo(txtPass.Text)==0 && Request["Action"].CompareTo("Delete") == 0)
        {
            sql = "delete from tblReBoard where num=" + Request["No"];
            SqlCommand cmd2 = new SqlCommand(sql, con);
            cmd2.ExecuteNonQuery();

            Response.Redirect("List.aspx");
        }
        con.Close();

    }
</script>

<style>
    table{
        /*border:1px solid;*/
        border-collapse:collapse;
        text-align:center;
        width:50%;
    }
    td{
        border-bottom:1px solid;
    }

</style>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>

            <table>
                <tr>
                    <td colspan="2"><h3>게시판 글보기</h3></td>
                </tr>
                
                <tr>
                    <td style="width:30%;">
                       비밀번호
                    </td>
                    <td style="text-align:left;">
                        <asp:TextBox ID="txtPass" runat="server"></asp:TextBox> <asp:Button ID="btnPass" runat="server" Text="확인" OnClick="btnPass_Click"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        
                        <asp:Button ID="Button2" runat="server" Text="목록보기" OnClick="Button2_Click"/>
                    </td>
                </tr>
            </table>

        </div>
    </form>
</body>
</html>
