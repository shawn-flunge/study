<%@ Page Language="C#" %>
<%@ Import Namespace="System.Data.SqlClient" %>

<!DOCTYPE html>

<script runat="server">

    protected void Button1_Click(object sender, EventArgs e)
    {
        SqlConnection con = new SqlConnection("Data Source=.\\SQLEXPRESS; Initial Catalog=MyDB; Integrated Security=False; uid=flunge; pwd=dksk1399");

       

        if (Request["Action"].CompareTo("Reply") != 0)
        {
            string sql = "insert into tblReBoard(name, pwd, email,title, contents, writedate,readcount,refer,depth,pos)" +
                "values(@name, @pwd, @email, @title, @contents, @writedate, 0,0,0,0)";

            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.Parameters.AddWithValue("@name", txtName.Text);
            cmd.Parameters.AddWithValue("@pwd", txtPass.Text);
            cmd.Parameters.AddWithValue("@email", txtEmail.Text);
            cmd.Parameters.AddWithValue("@title", txtTitle.Text);
            cmd.Parameters.AddWithValue("@contents", txtContents.Text);
            cmd.Parameters.AddWithValue("@writedate", DateTime.Now.ToShortDateString());

            con.Open();
            cmd.ExecuteNonQuery();

            sql = "update tblReBoard set refer=num where refer=0";
            cmd = new SqlCommand(sql, con);
            cmd.ExecuteNonQuery();
        }
        else
        {
            int iRefer = int.Parse(Request["refer"]);
            int iDepth = int.Parse(Request["depth"]);
            int iPos = int.Parse(Request["pos"]);

            string sql = "update tblReBoard set pos=pos+1 where refer=" + iRefer + "and pos>" + iPos;
            SqlCommand cmd = new SqlCommand(sql, con);
            cmd.ExecuteNonQuery();

            iDepth++;
            iPos++;

            sql = "insert into tblReBoard(name, pwd, email, title,contents,writedate,readcount, refer,depth,pos) values(" +
                "'" + txtName.Text + "', '" + txtPass.Text + "','"
                + txtEmail.Text + "','" + txtTitle.Text + "','"
                + txtContents.Text + "','" + DateTime.Now.ToShortDateString() + "',0" + iRefer + "," +
                iDepth + "," + iPos + ")";

            cmd = new SqlCommand(sql, con);
            cmd.ExecuteNonQuery();

        }



        con.Close();

        Response.Redirect("List.aspx");
        Response.Write(txtName.Text + "의 글을 입력완료 ~/List.aspx");
    }

    protected void Button2_Click(object sender, EventArgs e)
    {
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
            <h3 style="text-align:center">게시판 글쓰기</h3><hr />
            <table style="width:50%">
                <tr>
                    <td style="height:50px;width:100px; background-color:gray;">작성자</td>
                    <td>
                        <asp:TextBox ID="txtName" runat="server"></asp:TextBox> *필수
                    </td>
                </tr>
                <tr>
                    <td style="height:50px;width:100px; background-color:gray;">비밀번호</td>
                    <td>
                        <asp:TextBox ID="txtPass" runat="server" TextMode="Password"></asp:TextBox> *필수 (게시물 수정 삭제시 필요합니다.)
                    </td>
                </tr>
                <tr>
                    <td style="height:50px;width:100px; background-color:gray;">E-mail</td>
                    <td>
                        <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
                    </td>
                </tr>

            </table>
            <hr />
             <table style="width:50%">
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

            </table>
            <hr />
            <asp:Button ID="Button1" runat="server" Text="게시물 등록" OnClick="Button1_Click"/>
            <asp:Button ID="Button2" runat="server" Text="목록" OnClick="Button2_Click"/>



        </div>
    </form>
</body>
</html>
