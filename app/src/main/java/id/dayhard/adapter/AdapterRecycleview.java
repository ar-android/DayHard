package id.dayhard.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by ocittwo on 8/5/16.
 */
public abstract class AdapterRecycleview<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected int mModelLayout;
    Class<VH> mViewHolderClass;
    Class<T> mModelClass;
    ArrayList<T> mData;

    public AdapterRecycleview(ArrayList<T> mData, Class<T> mModelClass, int mModelLayout, Class<VH> mViewHolderClass) {
        this.mData = mData;
        this.mModelLayout = mModelLayout;
        this.mViewHolderClass = mViewHolderClass;
        this.mModelClass = mModelClass;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(mModelLayout, parent, false);
        try {
            Constructor<VH> constructor = mViewHolderClass.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T model = getItem(position);
        executeViewHolder(holder, model, position);
    }

    private T getItem(int position) {
        return mData.get(position);
    }

    abstract protected void executeViewHolder(VH viewHolder, T model, int position);

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
