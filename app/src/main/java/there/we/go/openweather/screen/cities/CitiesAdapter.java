package there.we.go.openweather.screen.cities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import there.we.go.openweather.model.City;

/**
 * @author Vladislav Falzan.
 */

public class CitiesAdapter extends RecyclerView.Adapter<CitiesHolder> {

    private final List<City> mCities;

    private OnItemClickListener mOnItemClickListener;

    private final View.OnClickListener mInternalListener = view -> {
        City city = (City) view.getTag();
        mOnItemClickListener.onItemClick(city);
    };

    public CitiesAdapter(OnItemClickListener onItemClickListener) {
        mCities = new ArrayList<>();
        mOnItemClickListener = onItemClickListener;
    }

    public void changeDataSet(List<City> cities) {
        mCities.clear();
        mCities.addAll(cities);
        notifyDataSetChanged();
    }

    public void clear() {
        mCities.clear();
        notifyDataSetChanged();
    }

    @Override
    public CitiesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CitiesHolder.create(parent.getContext());
    }

    @Override
    public void onBindViewHolder(CitiesHolder holder, int position) {
        City city = mCities.get(position);

        holder.bind(city);
        holder.itemView.setOnClickListener(mInternalListener);
        holder.itemView.setTag(city);
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    public interface OnItemClickListener {

        void onItemClick(City city);
    }
}
