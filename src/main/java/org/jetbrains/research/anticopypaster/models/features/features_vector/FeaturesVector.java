package org.jetbrains.research.anticopypaster.models.features.features_vector;

import org.jetbrains.research.anticopypaster.models.features.feature.Feature;
import org.jetbrains.research.anticopypaster.models.features.feature.IFeatureItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FeaturesVector implements IFeaturesVector {
    private List<IFeatureItem> features = new ArrayList<>();
    private int dimension;

    public FeaturesVector(int dimension) {
        this.dimension = dimension;
    }

    public void addFeature(final IFeatureItem item) {
        this.features.add(item);
    }

    @Override
    public double getFeature(Feature toSearch) {
        for (IFeatureItem item: features) {
            if (item.getId() == toSearch.getId()) {
                return item.getValue();
            }
        }

        return 0.0;
    }

    public List<Float> buildVector() {
        features.sort(Comparator.comparingInt(IFeatureItem::getId));
        int itemsPtr = 0;
        List<Float> result = new ArrayList<>();
        for (int i = 0; i < dimension; ++i) {
            if (itemsPtr != features.size() && features.get(itemsPtr).getId() == i) {
                result.add((float) features.get(itemsPtr++).getValue());
            } else {
                result.add(0f);
            }
        }

        return result;
    }
}
