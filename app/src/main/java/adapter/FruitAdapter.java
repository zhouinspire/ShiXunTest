package adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shixuntest.R;

import java.util.List;

import bean.Fruit;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> fruitList;
    static class ViewHolder extends RecyclerView.ViewHolder {

        View fruitView;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            fruitView = view;
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList1) {
        fruitList = fruitList1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(view.getContext(), "you click view"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
//        Log.e(fruit.getName(), "kkk ");
        CharSequence name = fruit.getName();
        holder.fruitName.setText(name);
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
