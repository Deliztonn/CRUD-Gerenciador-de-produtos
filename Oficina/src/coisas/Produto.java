package coisas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Produto {

	Scanner sc = new Scanner(System.in);

	private int id = 0;
	private String Nome;
	private int Quantidade;
	private double Preco;

	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String Entrada;
	private LocalDate Validade;

	public void Preenchimento() {
	
		System.out.print("\nNome do produto         : ");
		this.Nome = sc.nextLine();

		boolean Valido = false;
		while (!Valido) {
			try {
				System.out.print("\nQuantidade de estoque   : ");
				this.Quantidade = sc.nextInt();
				if (Quantidade <= 0) {
					System.err.println("Estoque deve ser maior que 0");
				} else {
					Valido = true;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("Número deve ser inteiro!!");
			}
		}

		Valido = false;
		while (!Valido) {
			try {
				sc.nextLine();
				System.out.print("\nPreço do produto      : R$");
				this.Preco = sc.nextDouble();
				if (this.Preco <= 0) {
					System.err.println("Preço deve ser maior que 0");
				} else {
					Valido = true;
				}
			} catch (Exception e) {
				System.err.println("Preço deve utilizar ',' ");
			}
		}

		Valido = false;
		while (!Valido) {
			try {
				sc.nextLine();
				System.out.print("\nValidade do produto(dd/mm/aaaa)   : ");
				setEntrada(sc.next());
				Valido = true;

			} catch (Exception e) {
				System.err.println("Data no formato errado!");
			}
		}
	}

	public void Editar(int resp) {
		switch (resp) {
		case 1:
			System.out.print("Novo nome de " + getNome() + ": ");
			sc.nextLine();
			this.Nome = sc.nextLine();
			break;
		case 2:
			boolean Valido = false;
			try {
				System.out.print("\nNova quantidade de estoque " + getNome() + ": ");
				this.Quantidade = sc.nextInt();
				if (Quantidade <= 0) {
					System.err.println("Estoque deve ser maior que 0");
				} else {
					Valido = true;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("Número deve ser inteiro!!");
			}
			break;
		case 3:
			Valido = false;
			while (!Valido) {
				try {
					System.out.print("\nNovo Preço de " + getNome() + " : R$");
					this.Preco = sc.nextDouble();
					if (this.Preco <= 0) {
						System.err.println("Preço deve ser maior que 0");
					} else {
						Valido = true;
					}
				} catch (Exception e) {
					System.err.println("Preço deve utilizar ',' ");
				}
			}
			break;
		case 4:
			Valido = false;
			while (!Valido) {
				try {
					sc.nextLine();
					System.out.print("Nova Validade " + getNome() + ": ");
					Valido = true;
					setEntrada(sc.next());
				} catch (Exception e) {
					System.err.println("Data no formato errado!");
				}
			}
			break;
		case 5:
			sc.nextLine();
			Preenchimento();
			break;

		default:
			System.out.println("Opção inválida");
			break;
		}
	}

	public void MostrarProdutos(List<Produto> produtos) {
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

	public void Ordenar(int resp, List<Produto> produtos) {
		switch (resp) {
		case 1:
			produtos.sort(Comparator.comparing(Produto::getId));
			MostrarProdutos(produtos);
			break;
		case 2:
			produtos.sort(Comparator.comparing(Produto::getNome));
			MostrarProdutos(produtos);
			break;
		case 3:
			produtos.sort(Comparator.comparing(Produto::getQuantidade));
			MostrarProdutos(produtos);
			break;
		case 4:
			produtos.sort(Comparator.comparing(Produto::getPreco));
			MostrarProdutos(produtos);
			break;
		case 5:
			produtos.sort(Comparator.comparing(Produto::getValidadeData));
			MostrarProdutos(produtos);
			break;
		default:
			System.out.println("Organização cancelada");

			break;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.Quantidade = quantidade;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		this.Preco = preco;
	}

	public LocalDate getValidadeData() {
		return Validade;
	}

	public String getValidade() {
		String validade = Validade.format(formato);
		return validade;

	}

	public String getEntrada() {
		return Entrada;
	}

	public void setEntrada(String Entrada) {
		this.Entrada = Entrada;
		Validade = LocalDate.parse(Entrada, formato);
	}

	@Override
	public String toString() {
		return " Id = " + id + ", Nome= " + Nome + ", Quantidade= " + Quantidade + ", Preco= " + Preco + ", Validade "
				+ getValidade();
	}
}
