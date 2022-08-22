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
    public class Iniciar : Button
    {
        public GraphicsPath getRound( int radius)
        {
            double radius2 = radius / 2;
            RectangleF rect = new RectangleF(0, 0, this.Width, this.Height);
            GraphicsPath path = new GraphicsPath();
            path.AddArc(rect.X, rect.Y, radius, radius, 180, 90);
            path.AddLine((int)(rect.X+radius2), (int)rect.Y, (int)(rect.Width-radius2), (int)rect.Y);
            path.AddArc((rect.X + rect.Width - radius), rect.Y, radius, radius, 270, 90);
            path.AddLine((int)rect.Width, (int)(rect.Y+radius2), (int)rect.Width, (int)(rect.Height-radius2));
            path.AddArc((rect.X + rect.Width - radius), (rect.Y + rect.Height - radius), radius, radius, 0, 90);
            path.AddLine((int)(rect.Width - radius2), (int)rect.Height, (int)(rect.X + radius2), (int)rect.Height);
            path.AddArc(rect.X, (rect.Y + rect.Height - radius), radius, radius, 90, 90);
            path.AddLine((int)rect.X, (int)(rect.Height - radius2), (int)rect.X, (int)(rect.Y + radius2));
            path.CloseFigure();

            return path;
        }

        protected override void OnPaint(PaintEventArgs pevent)
        {
            base.OnPaint(pevent);
            this.Region = new Region(getRound(10));
            Pen pen = new Pen(Color.CadetBlue, 0);
            pen.Alignment = PenAlignment.Inset;
            pevent.Graphics.DrawPath(pen, getRound(10));
        }

        public Iniciar()
        {
            this.Size = new Size(110, 44);
            this.BackColor = Color.FromArgb(40, 40, 40);
            this.ForeColor = Color.WhiteSmoke;
            this.FlatStyle = FlatStyle.Flat;
            
            this.Font = new Font("Arial", 14.25f, FontStyle.Bold, GraphicsUnit.Point);
            this.Text = "Iniciar";
        }

    }
}
