package com.example.spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "carrito")
public class Carrito implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrito")
    private Long idCarrito;

    @Column(name = "idproducto") //producto
    private Long idProducto;

    @Column(name="fecha", length = 45)
    private String fecha;

    @Column(name = "subtotal", length = 45)
    private String subtotal;
    
  //Relación OneToOne con Cliente
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
    
    
    @ManyToMany(mappedBy = "carritos")
    private List <Comida> comidas = new ArrayList<Comida>();
}
