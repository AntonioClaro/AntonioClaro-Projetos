using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Windows.Forms;
using System.Drawing;
using System.Drawing.Drawing2D;

namespace TSystemsProject.CustomElements
{
    public class Caixa : Panel
    {
        public Caixa()
        {
            this.Size = new Size(318, 322);
            this.BorderStyle = BorderStyle.FixedSingle;
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            SolidBrush brush = new SolidBrush(BackColor);
            e.Graphics.FillRectangle(brush, ClientRectangle);
            e.Graphics.DrawRectangle(Pens.LightGray, 0, 0, ClientSize.Width - 1, ClientSize.Height - 1);
        }
    }
}
