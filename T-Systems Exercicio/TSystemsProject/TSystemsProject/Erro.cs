using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TSystemsProject
{
    public partial class Erro : Form
    {
        public Erro(String mensagem)
        {
            InitializeComponent();
            this.razao.Text += " " + mensagem;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
