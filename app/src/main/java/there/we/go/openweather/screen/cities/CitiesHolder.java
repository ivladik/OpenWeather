package there.we.go.openweather.screen.cities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import there.we.go.openweather.R;
import there.we.go.openweather.model.City;

/**
 * @author Vladislav Falzan.
 */

public class CitiesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.city_name)
    TextView tvCityName;

    @BindView(R.id.city_temperature)
    TextView tvCityTemperature;

    public CitiesHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public static CitiesHolder create(Context context) {
        return new CitiesHolder(View.inflate(context, R.layout.city_item, null));
    }

    public void bind(City city) {
        tvCityName.setText(city.getName());
        tvCityTemperature.setText(String.valueOf(city.getMain().getTemp()));
    }
}
