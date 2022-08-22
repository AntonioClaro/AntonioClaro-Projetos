using System.Security.Policy;
using System.Text.RegularExpressions;
using System.Collections;
using System.Globalization;

namespace TSystemsProject
{
    public partial class Form1 : Form
    {
        private const string url = "https://apidev-mbb.t-systems.com.br:8443/edgemicro_tsdev/torneioluta/api/competidores";

        /*
         Variaveis de escopo globais que são utilizadas em todo o código
         */
        ArrayList nomes = new ArrayList();
        ArrayList idade = new ArrayList();
        ArrayList marciais = new ArrayList();
        ArrayList lutas = new ArrayList();
        ArrayList derrotas = new ArrayList();
        ArrayList vitorias = new ArrayList();

        ArrayList nomeParticipantes = new ArrayList();
        ArrayList idadeParticipantes = new ArrayList();
        ArrayList marciaisParticipantes = new ArrayList();
        ArrayList lutasParticipantes = new ArrayList();
        ArrayList derrotasParticipantes = new ArrayList();
        ArrayList vitoriasParticipantes = new ArrayList();

        ArrayList quartasFinais = new ArrayList();
        ArrayList semiFinais = new ArrayList();
        ArrayList final = new ArrayList();
        String campeao = "";

        public Form1()
        {  
            InitializeComponent();
            this.Text = "Torneio de Luta";
            con();
        }

        /*
         con()
          Função Responsavel por realizar a conexão com a API, manejar os dados recebidos e coloca-los a mostra na tela inicial.
         */
        public void con()
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri(url);
            client.DefaultRequestHeaders.Add("x-api-key", "29452a07-5ff9-4ad3-b472-c7243f548a33");
            HttpResponseMessage responseMessage = client.GetAsync("").Result;
            if (responseMessage.IsSuccessStatusCode)
            {
                string retornoAPI = responseMessage.Content.ReadAsStringAsync().Result.Remove(0, 1);
                retornoAPI = retornoAPI.Remove(0, 1);
                retornoAPI = retornoAPI.Remove(retornoAPI.Length - 1);
                
                Regex reg = new Regex(",(?=[^\\]]*(?:\\[|$))");
                String[] listaLutadores = retornoAPI.Split("},");
                for (int i = 0; i < listaLutadores.Length; i++)
                {
                    listaLutadores[i] = listaLutadores[i].Remove(0, 1);
                }

                listaLutadores[listaLutadores.Length - 1] = listaLutadores[listaLutadores.Length - 1].Replace('}', ' ');

                for (int i = 0; i < listaLutadores.Length; i++)
                {
                    String[] dadosLutador = reg.Split(listaLutadores[i]);

                    for(int j = 0; j < dadosLutador.Length; j++)
                    {
                        String temp = dadosLutador[j].Split(":")[1];
                        if(j == 1)
                        {
                            lutadores()[i].Text = temp.Replace('"', ' ');
                            nomes.Add(temp.Replace('"', ' '));
                        }
                        if (j == 2)
                        {
                            labels("idade")[i].Text += ' ' + temp.Replace('"', ' ');
                            idade.Add(int.Parse(temp.Replace('"', ' ')));
                        }
                        if (j == 3)
                        {
                            labels("marciais")[i].Text += "\n" + temp.Replace('"', ' ');
                            marciais.Add(temp.Replace('"', ' '));
                        }
                        if (j == 4)
                        {
                            labels("lutas")[i].Text += " " + temp.Replace('"', ' ');
                            lutas.Add(int.Parse(temp.Replace('"', ' ')));
                        }
                        if (j == 5)
                        {
                            labels("derrotas")[i].Text += " " + temp.Replace('"', ' ');
                            derrotas.Add(int.Parse(temp.Replace('"', ' ')));
                        }
                        if (j == 6)
                        {
                            labels("vitorias")[i].Text += " " + temp.Replace('"', ' ');
                            vitorias.Add(int.Parse(temp.Replace('"', ' ')));
                        }
                    }

                }

            }

        }

        /*
         public void fights(ArrayList numeros, String estagio)
          Responsavel pelo manejamento dos lutadores com base na idade, exceto nas semifinais e finais, onde o criterio de seleção muda.
         */
        public void fights(ArrayList numeros, String estagio)
        {
            nomeParticipantes.Clear();
            idadeParticipantes.Clear();
            marciaisParticipantes.Clear();
            lutasParticipantes.Clear();
            derrotasParticipantes.Clear();
            vitoriasParticipantes.Clear();
            foreach (int k in numeros)
            {
                String marciaisArray = (String)marciais[k];
                marciaisArray = marciaisArray.Substring(1, marciaisArray.Length - 2);

                nomeParticipantes.Add((String)nomes[k]);
                idadeParticipantes.Add((int)idade[k]);
                marciaisParticipantes.Add(marciaisArray.Split(','));
                lutasParticipantes.Add((int)lutas[k]);
                derrotasParticipantes.Add((int)derrotas[k]);
                vitoriasParticipantes.Add((int)vitorias[k]);
            }

            selector();

            void selector()
            {
                ArrayList lutadores1 = new ArrayList();
                ArrayList lutadores2 = new ArrayList();
                int menor1=0, menor2=0;
                ArrayList listados = new ArrayList();
                if(numeros.Count==2 || numeros.Count==4)
                {
                    lutadores1.Add(0);
                    lutadores2.Add(1);
                }
                if (numeros.Count == 4)
                {
                    lutadores1.Add(2);
                    lutadores2.Add(3);
                }
                if(numeros.Count > 4)
                {
                    for (int i = 0; i < numeros.Count / 2; i++)
                    {

                        for (int l = 0; l < idadeParticipantes.Count; l++)
                        {

                            if ((int)idadeParticipantes[l] <= (int)idadeParticipantes[menor1] && l != menor1 && !(listados.Contains(l)))
                            {
                                menor1 = l;
                            }
                        }

                        listados.Add(menor1);
                        lutadores1.Add(menor1);
                        idadeParticipantes[menor1] = int.MaxValue;

                        for (int l = 0; l < idadeParticipantes.Count; l++)
                        {
                            if ((int)idadeParticipantes[l] <= (int)idadeParticipantes[menor2] && l != menor2 && !(listados.Contains(l)))
                            {
                                menor2 = l;
                            }
                        }
                        listados.Add(menor2);
                        lutadores2.Add(menor2);
                        idadeParticipantes[menor2] = int.MaxValue;
                    }
                }
                
                for(int x=0;x<numeros.Count/2; x++)
                {
                    fightPhase((int)lutadores1[x], (int)lutadores2[x], estagio);
                }
            }

            /*
             void fightPhase(int lutadorA, int lutadorB, String estagio)
              Decide os vencedores dependendo de seus atributos, tais como porecentagem de vitorias e outros
             */
            void fightPhase(int lutadorA, int lutadorB, String estagio)
            {
                int porcentagemA = ((int)vitoriasParticipantes[lutadorA] / (int)lutasParticipantes[lutadorA]) * 100;
                int porcentagemB = ((int)vitoriasParticipantes[lutadorB] / (int)lutasParticipantes[lutadorB]) * 100;
                String[] artesMarciaisA = (String[])marciaisParticipantes[lutadorA];
                int quantidadeArtesA = artesMarciaisA.Length;
                String[] artesMarciaisB = (String[])marciaisParticipantes[lutadorB];
                int quantidadeArtesB = artesMarciaisB.Length;
                int lutasA = (int)lutasParticipantes[lutadorA];
                int lutasB = (int)lutasParticipantes[lutadorB];

                if(porcentagemA>porcentagemB)
                {
                    qualificado((int)numeros[lutadorA], estagio);
                }
                else
                {
                    if(porcentagemA<porcentagemB)
                    {
                        qualificado((int)numeros[lutadorB], estagio);
                    }
                    else
                    {
                        if(quantidadeArtesA>quantidadeArtesB)
                        {
                            qualificado((int)numeros[lutadorA], estagio);
                        }
                        else
                        {
                            if(quantidadeArtesA<quantidadeArtesB)
                            {
                                qualificado((int)numeros[lutadorB], estagio);
                            }
                            else
                            {
                                if (lutasA>lutasB)
                                {
                                    qualificado((int)numeros[lutadorA], estagio);
                                }
                                else
                                {
                                    qualificado((int)numeros[lutadorB], estagio);
                                }
                            }
                        }
                    }
                }
            }
            

        }

        /*
          public void qualificado(int lutador, String estagio)
           Define os lutadores da proxima etapa de lutas, o campeão
         */
        public void qualificado(int lutador, String estagio)
        {
            if(estagio == "Oitavas")
            {
                quartasFinais.Add(lutador);
            }
            if(estagio == "Quartas")
            {
                semiFinais.Add(lutador);
            }
            if(estagio == "Semi")
            {
                final.Add(lutador);
            }
            if (estagio == "Final")
            {
                campeao=(String)nomes[lutador];
            }
        }

        /*lutadores()
          Responsavel por retornar uma lista com as variaveis de checkbox
         */
        public CheckBox[] lutadores()
        {
            CheckBox[] lutador = new CheckBox[37];
            lutador[0] = lutador1;
            lutador[1] = lutador2;
            lutador[2] = lutador3;
            lutador[3] = lutador4;
            lutador[4] = lutador5;
            lutador[5] = lutador6;
            lutador[6] = lutador7;
            lutador[7] = lutador8;
            lutador[8] = lutador9;
            lutador[9] = lutador10;
            lutador[10] = lutador11;
            lutador[11] = lutador12;
            lutador[12] = lutador13;
            lutador[13] = lutador14;
            lutador[14] = lutador15;
            lutador[15] = lutador16;
            lutador[16] = lutador17;
            lutador[17] = lutador18;
            lutador[18] = lutador19;
            lutador[19] = lutador20;
            lutador[20] = lutador21;
            lutador[21] = lutador22;
            lutador[22] = lutador23;
            lutador[23] = lutador24;
            lutador[24] = lutador25;
            lutador[25] = lutador26;
            lutador[26] = lutador27;
            lutador[27] = lutador28;
            lutador[28] = lutador29;
            lutador[29] = lutador30;
            lutador[30] = lutador31;
            lutador[31] = lutador32;
            lutador[32] = lutador33;
            lutador[33] = lutador34;
            lutador[34] = lutador35;
            lutador[35] = lutador36;
            lutador[36] = lutador37;
            return lutador;
        }

        /*labels()
          Responsavel por retornar uma lista com os labels, recebendo como parametro um valor que define se serão os labels de idade, lutas, vitorias, etc...
         */
        public Label[] labels(String type)
        {
            if (type == "idade")
            {
                Label[] labels = new Label[37];
                labels[0] = idade1;
                labels[1] = idade2;
                labels[2] = idade3;
                labels[3] = idade4;
                labels[4] = idade5;
                labels[5] = idade6;
                labels[6] = idade7;
                labels[7] = idade8;
                labels[8] = idade9;
                labels[9] = idade10;
                labels[10] = idade11;
                labels[11] = idade12;
                labels[12] = idade13;
                labels[13] = idade14;
                labels[14] = idade15;
                labels[15] = idade16;
                labels[16] = idade17;
                labels[17] = idade18;
                labels[18] = idade19;
                labels[19] = idade20;
                labels[20] = idade21;
                labels[21] = idade22;
                labels[22] = idade23;
                labels[23] = idade24;
                labels[24] = idade25;
                labels[25] = idade26;
                labels[26] = idade27;
                labels[27] = idade28;
                labels[28] = idade29;
                labels[29] = idade30;
                labels[30] = idade31;
                labels[31] = idade32;
                labels[32] = idade33;
                labels[33] = idade34;
                labels[34] = idade35;
                labels[35] = idade36;
                labels[36] = idade37;
                return labels;
            }

            if(type=="lutas")
            {
                Label[] labels = new Label[37];
                labels[0] = lutas1;
                labels[1] = lutas2;
                labels[2] = lutas3;
                labels[3] = lutas4;
                labels[4] = lutas5;
                labels[5] = lutas6;
                labels[6] = lutas7;
                labels[7] = lutas8;
                labels[8] = lutas9;
                labels[9] = lutas10;
                labels[10] = lutas11;
                labels[11] = lutas12;
                labels[12] = lutas13;
                labels[13] = lutas14;
                labels[14] = lutas15;
                labels[15] = lutas16;
                labels[16] = lutas17;
                labels[17] = lutas18;
                labels[18] = lutas19;
                labels[19] = lutas20;
                labels[20] = lutas21;
                labels[21] = lutas22;
                labels[22] = lutas23;
                labels[23] = lutas24;
                labels[24] = lutas25;
                labels[25] = lutas26;
                labels[26] = lutas27;
                labels[27] = lutas28;
                labels[28] = lutas29;
                labels[29] = lutas30;
                labels[30] = lutas31;
                labels[31] = lutas32;
                labels[32] = lutas33;
                labels[33] = lutas34;
                labels[34] = lutas35;
                labels[35] = lutas36;
                labels[36] = lutas37;
                return labels;
            }
            if(type=="marciais")
            {
                Label[] labels = new Label[37];
                labels[0] = marciais1;
                labels[1] = marciais2;
                labels[2] = marciais3;
                labels[3] = marciais4;
                labels[4] = marciais5;
                labels[5] = marciais6;
                labels[6] = marciais7;
                labels[7] = marciais8;
                labels[8] = marciais9;
                labels[9] = marciais10;
                labels[10] = marciais11;
                labels[11] = marciais12;
                labels[12] = marciais13;
                labels[13] = marciais14;
                labels[14] = marciais15;
                labels[15] = marciais16;
                labels[16] = marciais17;
                labels[17] = marciais18;
                labels[18] = marciais19;
                labels[19] = marciais20;
                labels[20] = marciais21;
                labels[21] = marciais22;
                labels[22] = marciais23;
                labels[23] = marciais24;
                labels[24] = marciais25;
                labels[25] = marciais26;
                labels[26] = marciais27;
                labels[27] = marciais28;
                labels[28] = marciais29;
                labels[29] = marciais30;
                labels[30] = marciais31;
                labels[31] = marciais32;
                labels[32] = marciais33;
                labels[33] = marciais34;
                labels[34] = marciais35;
                labels[35] = marciais36;
                labels[36] = marciais37;
                return labels;
            }

            if (type == "derrotas")
            {
                Label[] labels = new Label[37];
                labels[0] = derrotas1;
                labels[1] = derrotas2;
                labels[2] = derrotas3;
                labels[3] = derrotas4;
                labels[4] = derrotas5;
                labels[5] = derrotas6;
                labels[6] = derrotas7;
                labels[7] = derrotas8;
                labels[8] = derrotas9;
                labels[9] = derrotas10;
                labels[10] = derrotas11;
                labels[11] = derrotas12;
                labels[12] = derrotas13;
                labels[13] = derrotas14;
                labels[14] = derrotas15;
                labels[15] = derrotas16;
                labels[16] = derrotas17;
                labels[17] = derrotas18;
                labels[18] = derrotas19;
                labels[19] = derrotas20;
                labels[20] = derrotas21;
                labels[21] = derrotas22;
                labels[22] = derrotas23;
                labels[23] = derrotas24;
                labels[24] = derrotas25;
                labels[25] = derrotas26;
                labels[26] = derrotas27;
                labels[27] = derrotas28;
                labels[28] = derrotas29;
                labels[29] = derrotas30;
                labels[30] = derrotas31;
                labels[31] = derrotas32;
                labels[32] = derrotas33;
                labels[33] = derrotas34;
                labels[34] = derrotas35;
                labels[35] = derrotas36;
                labels[36] = derrotas37;
                return labels;
            }

            if (type == "vitorias")
            {
                Label[] labels = new Label[37];
                labels[0] = vitorias1;
                labels[1] = vitorias2;
                labels[2] = vitorias3;
                labels[3] = vitorias4;
                labels[4] = vitorias5;
                labels[5] = vitorias6;
                labels[6] = vitorias7;
                labels[7] = vitorias8;
                labels[8] = vitorias9;
                labels[9] = vitorias10;
                labels[10] = vitorias11;
                labels[11] = vitorias12;
                labels[12] = vitorias13;
                labels[13] = vitorias14;
                labels[14] = vitorias15;
                labels[15] = vitorias16;
                labels[16] = vitorias17;
                labels[17] = vitorias18;
                labels[18] = vitorias19;
                labels[19] = vitorias20;
                labels[20] = vitorias21;
                labels[21] = vitorias22;
                labels[22] = vitorias23;
                labels[23] = vitorias24;
                labels[24] = vitorias25;
                labels[25] = vitorias26;
                labels[26] = vitorias27;
                labels[27] = vitorias28;
                labels[28] = vitorias29;
                labels[29] = vitorias30;
                labels[30] = vitorias31;
                labels[31] = vitorias32;
                labels[32] = vitorias33;
                labels[33] = vitorias34;
                labels[34] = vitorias35;
                labels[35] = vitorias36;
                labels[36] = vitorias37;
                return labels;
            }
            return new Label[0];
        }

        /*
         Inicio_MouseClick(object sender, MouseEventArgs e)
          Quando o botão de "Inicio" é clicado, está função inicia o processo de torneio caso forem selecionados exatamente 16 lutadores, para então chamar uma janela anunciando
          o vencedor, caso contrario, retorna uma jánela de erro informando que o numero de lutadores não é aceitavel.
         */
        private void Inicio_MouseClick(object sender, MouseEventArgs e)
        {
            var numeros = new ArrayList();
            quartasFinais.Clear();
            semiFinais.Clear();
            final.Clear();
            
            for (int i = 0; i < lutadores().Length; i++)
            {
                if (lutadores()[i].Checked)
                {
                    numeros.Add(i);
                }
            }
            if (numeros.Count == 16)
            {
                fights(numeros, "Oitavas");

                numeros.Clear();

                for (int i = 0; i < quartasFinais.Count; i++)
                {
                    numeros.Add(quartasFinais[i]);
                }

                fights(numeros, "Quartas");

                numeros.Clear();


                for (int i = 0; i < semiFinais.Count; i++)
                {
                    numeros.Add(semiFinais[i]);
                }

                fights(numeros, "Semi");

                numeros.Clear();

                for (int i = 0; i < final.Count; i++)
                {
                    numeros.Add(final[i]);
                }

                fights(numeros, "Final");

                numeros.Clear();

                Campeao vencedor = new Campeao(campeao);
                vencedor.Show();
            }
            else
            {
                if (numeros.Count < 16)
                {
                    Erro erro = new Erro("Nº de lutadores em falta.");
                    erro.Show();
                }
                if (numeros.Count > 16)
                {
                    Erro erro = new Erro("Nº de lutadores em excesso.");
                    erro.Show();
                }               
            }
        }
    }
}