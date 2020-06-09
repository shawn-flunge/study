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

            string sql = "update tblReBoard set readcount=readcount+1 where num =" + Request["No"];
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.ExecuteNonQuery();

            sql = "select * from tblReBoard where num=" + Request["No"];
            cmd = new SqlCommand(sql, con);

            SqlDataReader rd = cmd.ExecuteReader();
            if (rd.Read())
            {
                lblName.Text = rd["name"].ToString();
                lblDate.Text = rd["writedate"].ToString();
                lblCount.Text = rd["readcount"].ToString();
                lblTitle.Text = rd["title"].ToString();
                txtContents.Text = rd["contents"].ToString();

                lblRefer.Text = rd["refer"].ToString();
                lblDepth.Text = rd["depth"].ToString();
                lblPos.Text = rd["pos"].ToString();
            }

            rd.Close();
            con.Close();
        }
    }

    protected void btnList_Click(object sender, EventArgs e)
    {
        Response.Redirect("List.aspx");
    }

    protected void btnDelete_Click(object sender, EventArgs e)
    {
        Response.Redirect("Pass.aspx?Action=Delete&No="+Request["No"]);
    }

    protected void btnUpdate_Click(object sender, EventArgs e)
    {
        Response.Redirect("Pass.aspx?Action=Modify&No="+Request["No"]);
    }

    protected void btnReply_Click(object sender, EventArgs e)
    {
        Response.Redirect("write.aspx?Action=Reply%No=" + Request["No"] + "&Refer=" + lblRefer.Text +
            "&depth=" + lblDepth.Text + "&pos=" + lblPos.Text);
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
                    <td style="text-align:left;">
                        작성자 : <asp:Label ID="lblName" runat="server" Text=""></asp:Label>
                    </td>
                    <td style="text-align:right;">
                        작성일 : <asp:Label ID="lblDate" runat="server" Text=""></asp:Label>
                        조회수 : <asp:Label ID="lblCount" runat="server" Text=""></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="background-color:lightgray;">
                        <asp:Label ID="lblTitle" runat="server" Text=""></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <asp:TextBox ID="txtContents" runat="server" ReadOnly="true" TextMode="MultiLine" Width="100%" Height="300px" ></asp:TextBox>
                    </td>
                </tr>
                 <tr>
                    <td colspan="2">
                        <hr />
                    </td>
                </tr>
                <tr>
                    <td style="text-align:left;">
                        <asp:Button ID="btnUpdate" runat="server" Text="수정" OnClick="btnUpdate_Click"/>
                        <asp:Button ID="btnDelete" runat="server" Text="삭제" OnClick="btnDelete_Click"/>
                    </td>
                    <td  style="text-align:right;">
                        <asp:Button ID="btnReply" runat="server" Text="답변등록" OnClick="btnReply_Click"/>
                        <asp:Button ID="btnList" runat="server" Text="목록보기" OnClick="btnList_Click"/>
                    </td>
                </tr>
            </table>
            <asp:Label ID="lblRefer" runat="server" Text="" Visible="false"></asp:Label>
            <asp:Label ID="lblDepth" runat="server" Text="" Visible="false"></asp:Label>
            <asp:Label ID="lblPos" runat="server" Text="" Visible="false"></asp:Label>

        </div>
    </form>
</body>
</html>
