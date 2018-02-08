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

    private final OnItemClickListener mOnItemClickListener;

    private final View.OnClickListener mInternalListener = view -> {
        City city = (City) view.getTag();
//        mOnItemClickListener.onItemClick(view, city);
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

    @Override
    public CitiesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CitiesHolder.create(parent.getContext());
    }

    @Override
    public void onBindViewHolder(CitiesHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface OnItemClickListener {

        void onItemClick(View view, City city);
    }
}
