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
    public class CaixaSelecao: CheckBox
    {
        public override bool AutoSize 
        { 
            set => base.AutoSize = false; 
            get => base.AutoSize;
        }

        protected override void OnPaint(PaintEventArgs pevent)
        {
            base.OnPaint(pevent);
            int squareSide = 30;
            Rectangle rect = new Rectangle(new Point(0, 1), new Size(squareSide, squareSide));
            ControlPaint.DrawCheckBox(pevent.Graphics, rect, this.Checked ? ButtonState.Checked : ButtonState.Normal);
        }
    }
}
