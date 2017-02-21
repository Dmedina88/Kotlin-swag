package com.grayherring.kotlintest.test;

import android.view.View;
import com.grayherring.kotlintest.BR;
import com.grayherring.kotlintest.R;
import com.grayherring.kotlintest.databinding.ActivityHomeBinding;

/**
 * Created by davidmedina on 2/21/17 =).
 */

public class HomeBookBinding extends android.databinding.ViewDataBinding
    implements android.databinding.generated.callback.OnClickListener.Listener {

  private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
  private static final android.util.SparseIntArray sViewsWithIds;

  static {
    sIncludes = null;
    sViewsWithIds = new android.util.SparseIntArray();
    sViewsWithIds.put(R.id.recyclerView, 3);
  }

  // views
  public final android.widget.RelativeLayout activityHome;
  private final android.support.design.widget.FloatingActionButton mboundView1;
  public final android.widget.ProgressBar progress;
  public final android.support.v7.widget.RecyclerView recyclerView;
  // variables
  private com.grayherring.kotlintest.ui.home.HomeVM mVm;
  private final android.view.View.OnClickListener mCallback3;
  // values
  // listeners
  // Inverse Binding Event Handlers

  public HomeBookBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
    super(bindingComponent, root, 1);
    final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
    this.activityHome = (android.widget.RelativeLayout) bindings[0];
    this.activityHome.setTag(null);
    this.mboundView1 = (android.support.design.widget.FloatingActionButton) bindings[1];
    this.mboundView1.setTag(null);
    this.progress = (android.widget.ProgressBar) bindings[2];
    this.progress.setTag(null);
    this.recyclerView = (android.support.v7.widget.RecyclerView) bindings[3];
    setRootTag(root);
    // listeners
    mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 1);
    invalidateAll();
  }

  @Override
  public void invalidateAll() {
    synchronized (this) {
      mDirtyFlags = 0x2L;
    }
    requestRebind();
  }

  @Override
  public boolean hasPendingBindings() {
    synchronized (this) {
      if (mDirtyFlags != 0) {
        return true;
      }
    }
    return false;
  }

  public boolean setVariable(int variableId, Object variable) {
    switch (variableId) {
      case 1://BR.vm:
        setVm((com.grayherring.kotlintest.ui.home.HomeVM) variable);
        return true;
    }
    return false;
  }

  public void setVm(com.grayherring.kotlintest.ui.home.HomeVM vm) {
    //updateRegistration(0, vm);
    this.mVm = vm;
    synchronized (this) {
      mDirtyFlags |= 0x1L;
    }
    notifyPropertyChanged(BR.vm);
    super.requestRebind();
  }

  public com.grayherring.kotlintest.ui.home.HomeVM getVm() {
    return mVm;
  }

  @Override
  protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
    switch (localFieldId) {
      case 0:
        return onChangeVm((com.grayherring.kotlintest.ui.home.HomeVM) object, fieldId);
    }
    return false;
  }

  private boolean onChangeVm(com.grayherring.kotlintest.ui.home.HomeVM vm, int fieldId) {
    switch (fieldId) {
      case 1: {//BR._all: {
        synchronized (this) {
          mDirtyFlags |= 0x1L;
        }
        return true;
      }
    }
    return false;
  }

  @Override
  protected void executeBindings() {
    long dirtyFlags = 0;
    synchronized (this) {
      dirtyFlags = mDirtyFlags;
      mDirtyFlags = 0;
    }
    int loadingVmVISIBLEView = 0;
    com.grayherring.kotlintest.ui.home.HomeVM vm = mVm;
    boolean loadingVm = false;

    if ((dirtyFlags & 0x3L) != 0) {

      if (vm != null) {
        // read vm.loading
        loadingVm = vm.getLoading();
      }
      if ((dirtyFlags & 0x3L) != 0) {
        if (loadingVm) {
          dirtyFlags |= 0x8L;
        } else {
          dirtyFlags |= 0x4L;
        }
      }

      // read vm.loading ? View.VISIBLE : View.GONE
      loadingVmVISIBLEView = (loadingVm) ? (android.view.View.VISIBLE) : (android.view.View.GONE);
    }
    // batch finished
    if ((dirtyFlags & 0x2L) != 0) {
      // api target 1

      this.mboundView1.setOnClickListener(mCallback3);
    }
    if ((dirtyFlags & 0x3L) != 0) {
      // api target 1

      this.progress.setVisibility(loadingVmVISIBLEView);
    }
  }

  // Listener Stub Implementations
  // callback impls
  public final void _internalCallbackOnClick(int sourceId, android.view.View callbackArg_0) {
    // localize variables for thread safety
    // vm != null
    boolean vmObjectnull = false;
    // vm
    com.grayherring.kotlintest.ui.home.HomeVM vm = mVm;

    vmObjectnull = (vm) != (null);
    if (vmObjectnull) {

      vm.newBook();
    }
  }

  // dirty flag
  private long mDirtyFlags = 0xffffffffffffffffL;

  public static ActivityHomeBinding inflate(
      android.view.LayoutInflater inflater,
      android.view.ViewGroup root,
      boolean attachToRoot) {
    return inflate(
        inflater,
        root,
        attachToRoot,
        android.databinding.DataBindingUtil.getDefaultComponent()
    );
  }

  public static ActivityHomeBinding inflate(
      android.view.LayoutInflater inflater,
      android.view.ViewGroup root,
      boolean attachToRoot,
      android.databinding.DataBindingComponent bindingComponent) {
    return android.databinding.DataBindingUtil.<ActivityHomeBinding>inflate(
        inflater,
        com.grayherring.kotlintest.R.layout.activity_home,
        root,
        attachToRoot,
        bindingComponent
    );
  }

  public static HomeBookBinding inflate(android.view.LayoutInflater inflater) {
    return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
  }

  public static HomeBookBinding inflate(
      android.view.LayoutInflater inflater,
      android.databinding.DataBindingComponent bindingComponent) {
    return bind(
        inflater.inflate(com.grayherring.kotlintest.R.layout.activity_home, null, false),
        bindingComponent
    );
  }

  public static HomeBookBinding bind(android.view.View view) {
    return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
  }

  public static HomeBookBinding bind(
      android.view.View view,
      android.databinding.DataBindingComponent bindingComponent) {
    if (!"layout/activity_home_0".equals(view.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
    return new HomeBookBinding(bindingComponent, view);
  }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): null
        flag 2 (0x3L): vm.loading ? View.VISIBLE : View.GONE
        flag 3 (0x4L): vm.loading ? View.VISIBLE : View.GONE
    flag mapping end*/
  //end
}