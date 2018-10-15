package br.com.marcelo.iddog.imagem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.marcelo.iddog.R;

public class ImagensAdapter extends RecyclerView.Adapter<ImagensAdapter.ImagemViewHolder> {

    private List<String> imagens;
    private Context context;
    private OnItemClickListener listener;

    public ImagensAdapter(Context context, List<String> imagens, OnItemClickListener listener) {
        this.context = context;
        this.imagens = imagens;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImagensAdapter.ImagemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_imagem, parent, false);
        return new ImagemViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagensAdapter.ImagemViewHolder holder, int position) {
        String imagem = imagens.get(position);
        holder.bind(imagem, listener);

    }

    @Override
    public int getItemCount() {
        return imagens.size();
    }

    class ImagemViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        public ImagemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.url_da_imagem);
        }

        public void bind(final String urlImagem, final OnItemClickListener listener) {
            Picasso.get().load(urlImagem).into(imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(urlImagem);
                }
            });
        }
    }
}
