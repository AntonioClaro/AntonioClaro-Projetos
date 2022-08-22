using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.RegularExpressions;

namespace TSystemsProject
{
    

    internal static class Program
    {
        private const string url = "https://apidev-mbb.t-systems.com.br:8443/edgemicro_tsdev/torneioluta/api/competidores";

        /// <summary>
        ///  The main entry point for the application.
        /// </summary>
        [STAThread]




        static void Main()
        {

            // To customize application configuration such as set high DPI settings or default font,
            // see https://aka.ms/applicationconfiguration.
            ApplicationConfiguration.Initialize();
            Application.Run(new Form1());


            /*HttpClient client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Add("x-api-key", "29452a07-5ff9-4ad3-b472-c7243f548a33");
            HttpResponseMessage responseMessage = client.GetAsync("").Result;
            if (responseMessage.IsSuccessStatusCode)
            {
                string dataObjects = responseMessage.Content.ReadAsStringAsync().Result;
                string x = dataObjects.Remove(0, 1);
                string z = x.Remove(x.Length - 1);
                Regex reg = new Regex(",(?=[^\\]]*(?:\\[|$))");

                String[] xx = z.Split("},");
                for (int i = 0; i < xx.Length - 1; i++)
                {
                    xx[i] = xx[i].Remove(0, 1);
                }
                //String[] zz = reg.Split(xx[27]);
                for (int i = 0; i < xx.Length - 1; i++)
                {
                    String[] zz = reg.Split(xx[i]);

                    foreach (String s in zz)
                    {
                        object[] temp = s.Split(":");
                        
                        
                    }



                }


                for (int i = 0; i < xx.Length - 1; i++)
                {
                    Console.WriteLine(xx[i]);
                }
            }*/
        }
    }
}