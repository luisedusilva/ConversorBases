package Conversor;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.*;

public class ConversorBases extends JFrame {

    Numero numero = new Numero();

    private JButton botaoConverter, botaoSair;
    private JComboBox basesEntrada, basesSaida;
    private JLabel labelEntradaNumero, labelEntradaBase, labelSaidaNumero, labelSaidaBase;
    private JTextField textoEntradaNumero, textoSaidaNumero;

    public ConversorBases() {
        super(Informacao.getNomePrograma());

        String bases[] = {
            "Binário", "", "", "", "", "", "Octal", "", "Decimal", "", "", "",
            "", "", "Hexadecimal"};

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        labelEntradaBase = new JLabel("Base do número de entrada");
        basesEntrada = new JComboBox(bases);
        basesEntrada.setSelectedIndex(0);
        container.add(labelEntradaBase);
        container.add(basesEntrada);

        labelEntradaNumero = new JLabel("Número de entrada");
        container.add(labelEntradaNumero);

        textoEntradaNumero = new JTextField(10);

        textoEntradaNumero.addActionListener(
                
                new ActionListener() {
                    
                    public void actionPerformed(ActionEvent actionEvent) {
                        numero.setBase((byte) (basesEntrada.getSelectedIndex() + 2));

                        int resultado = numero.setValor(textoEntradaNumero.getText(),
                                numero.getBase());

                        if (resultado == 0) {
                            textoSaidaNumero.setText(numero.toBase((byte) (basesSaida.getSelectedIndex() + 2)));
                        } else if (resultado == 1) {
                            JOptionPane.showMessageDialog(null,
                                    "O número é inválido.",
                                    "Nenhum valor fornecido.",
                                    JOptionPane.ERROR_MESSAGE);

                           
                        } else if (resultado == 2) {
                            JOptionPane.showMessageDialog(null,
                                    "O número deve conter APENAS dígitos válidos.",
                                    "Caractere inválido",
                                    JOptionPane.ERROR_MESSAGE);

                          
                        } else if (resultado == 3) {
                            JOptionPane.showMessageDialog(null,
                                    "Cada dígito do número deve ser MENOR que o base.",
                                    "Número inválido para o base especificado",
                                    JOptionPane.ERROR_MESSAGE);

                            
                        }
                    }
                } 
        );

        container.add(textoEntradaNumero);

        labelSaidaBase = new JLabel("Base do número de saída");
        basesSaida = new JComboBox(bases);
        container.add(labelSaidaBase);
        container.add(basesSaida);

        labelSaidaNumero = new JLabel("Número de saída");
        textoSaidaNumero = new JTextField(15);
        textoSaidaNumero.setEditable(false);
        container.add(labelSaidaNumero);
        container.add(textoSaidaNumero);

        botaoConverter = new JButton("Converter");

        botaoConverter.addActionListener(
                
                new ActionListener() {
                    
                    public void actionPerformed(ActionEvent actionEvent) {
                        numero.setBase((byte) (basesEntrada.getSelectedIndex() + 2));

                        int resultado = numero.setValor(textoEntradaNumero.getText(),
                                numero.getBase());

                        if (resultado == 0) {
                            textoSaidaNumero.setText(numero.toBase((byte) (basesSaida.getSelectedIndex() + 2)));
                        } else if (resultado == 1) {
                            JOptionPane.showMessageDialog(null,
                                    "Entre com um número válido.",
                                    "Número em branco",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (resultado == 2) {
                            JOptionPane.showMessageDialog(null,
                                    "O número deve conter APENAS dígitos válidos.",
                                    "Caractere inválido",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (resultado == 3) {
                            JOptionPane.showMessageDialog(null,
                                    "Cada dígito do número deve ser MENOR que o base.",
                                    "Número inválido para o base especificado",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } 
        );

        container.add(botaoConverter);

        botaoSair = new JButton("Sair");

        botaoSair.addActionListener(
                
                new ActionListener() {
                    
                    public void actionPerformed(ActionEvent actionEvent) {
                        System.exit(0);
                    }
                } 
        );

        container.add(botaoSair);

        setSize(570, 120); 
        setResizable(false); 
        show(); 
    } 

    // Executa
    public static void main(String args[]) {
        Informacao.setNomePrograma("Conversor de Bases");

        ConversorBases aplicacao = new ConversorBases();

        aplicacao.addWindowListener(
                
                new WindowAdapter() {
                    
                    public void windowClosing(WindowEvent windowEvent) {
                        System.exit(0);
                    }
                }
        );
    } 
} 

