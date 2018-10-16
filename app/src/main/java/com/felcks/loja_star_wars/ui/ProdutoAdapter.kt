package com.felcks.loja_star_wars.ui

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.felcks.loja_star_wars.R
import com.felcks.loja_star_wars.domain.Produto
import com.felcks.loja_star_wars.transformarEmDinheiro
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_produto.view.*

/**
 * Created by hal on 16/10/18.
 */
class ProdutoAdapter(val context: Context,
                     val produtos: MutableList<Produto>): RecyclerView.Adapter<ProdutoAdapter.MyViewHolder>() {


    val mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getItemCount(): Int = produtos.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val produto = produtos[position]

        holder.itemView.tv_title.text = produto.titulo
        holder.itemView.tv_preco.text = produto.preco.transformarEmDinheiro()
        holder.itemView.tv_vendedor.text = produto.vendedor

        Picasso.with(context).load(produto.imagem).into(holder.itemView.iv_foto)

        holder.itemView.iv_foto.setOnClickListener{

            val intent = Intent(context, ImageZoomActivity::class.java)
            intent.putExtra(ImageZoomActivity.NomesExtras_Imagem, produto.imagem)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): MyViewHolder {

        val view: View = mLayoutInflater.inflate(R.layout.item_produto, parent, false)
        val mvh = MyViewHolder(view)

        return mvh
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {}
}