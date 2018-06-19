using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TRABALHODS
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCalcular_Click(object sender, EventArgs e)
        {
            // Transforma as informações dadas pelo usuário em texto, para posteriormente mostra-las na tela
            // \n é para pular linhas
            lblDados.Text = "Nome produto: " + txtNome.Text + "\nPreço: " + txtPreco.Text + "\nQuantidade: " + txtQntd.Text
               + "\nTipo Produto: " + cboTipo.Text;
            //declaração dos tipos de variáveis e convertendo de texto para número
            float preco, qntd, total;
            preco = float.Parse(txtPreco.Text);
            qntd = float.Parse(txtQntd.Text);

            total = preco * qntd;   //variável usada para calcular o resultado
            txtPagar.Text = total.ToString("C");  //conversão de número para texto

        }

        private void btnNovo_Click(object sender, EventArgs e)
        {
            //função que executa a limpeza dos campos quando o usuário clica no botão "novo"
            txtNome.Text = "";
            txtPreco.Text = "";
            txtQntd.Text = "";
            cboTipo.Text = "";
            txtPagar.Text = "";
            lblDados.Text = "";
            txtRecebido.Text = "";
            txtTroco.Text = "";
            pictureBox2.Visible = false;
            txtNome.Focus(); //retorna o cursor do mouse no primeiro campo
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            float preco, qntd, vRecebido, troco, total;
            preco = float.Parse(txtPreco.Text);
            qntd = float.Parse(txtQntd.Text);
            vRecebido = float.Parse(txtRecebido.Text);

            total = preco * qntd;
            troco = vRecebido - total;
            txtTroco.Text = troco.ToString("C");

            pictureBox2.Visible = true;
        }
    }
}
