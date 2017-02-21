package com.grayherring.kotlintest.test;

import android.view.View;

/**
 * Created by davidmedina on 2/21/17 =).
 */


public class UpdateBookBinding extends android.databinding.ViewDataBinding
    implements android.databinding.generated.callback.OnClickListener.Listener {

  private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
  private static final android.util.SparseIntArray sViewsWithIds;

  static {
    sIncludes = null;
    sViewsWithIds = null;
  }

  // views
  public final android.widget.EditText authorEdittext;
  public final android.widget.EditText bookTitleTextEdit;
  public final android.widget.EditText categoriesEdittext;
  public final android.widget.Button copyButton;
  public final android.widget.EditText publisherEdittext;
  public final android.widget.LinearLayout root;
  public final android.widget.Button submitButton;
  // variables
  private com.grayherring.kotlintest.ui.update.UpdateVM mVm;
  private final android.view.View.OnClickListener mCallback2;
  private final android.view.View.OnClickListener mCallback1;
  // values
  // listeners
  // Inverse Binding Event Handlers
  private android.databinding.InverseBindingListener authorEdittextandroi =
      new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
          // Inverse of vm.book.author
          //         is vm.book.setAuthor((java.lang.String) callbackArg_0)
          java.lang.String callbackArg_0 =
              android.databinding.adapters.TextViewBindingAdapter.getTextString(authorEdittext);
          // localize variables for thread safety
          // vm != null
          boolean vmObjectnull = false;
          // vm.book != null
          boolean bookVmObjectnull = false;
          // vm
          com.grayherring.kotlintest.ui.update.UpdateVM vm = mVm;
          // vm.book.author
          java.lang.String authorBookVm = null;
          // vm.book
          com.grayherring.kotlintest.data.modul.Book bookVm = null;

          vmObjectnull = (vm) != (null);
          if (vmObjectnull) {

            bookVm = vm.getBook();

            bookVmObjectnull = (bookVm) != (null);
            if (bookVmObjectnull) {

              bookVm.setAuthor((java.lang.String) (callbackArg_0));
            }
          }
        }
      };
  private android.databinding.InverseBindingListener bookTitleTextEditand =
      new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
          // Inverse of vm.book.title
          //         is vm.book.setTitle((java.lang.String) callbackArg_0)
          java.lang.String callbackArg_0 =
              android.databinding.adapters.TextViewBindingAdapter.getTextString(bookTitleTextEdit);
          // localize variables for thread safety
          // vm != null
          boolean vmObjectnull = false;
          // vm.book != null
          boolean bookVmObjectnull = false;
          // vm
          com.grayherring.kotlintest.ui.update.UpdateVM vm = mVm;
          // vm.book.title
          java.lang.String titleBookVm = null;
          // vm.book
          com.grayherring.kotlintest.data.modul.Book bookVm = null;

          vmObjectnull = (vm) != (null);
          if (vmObjectnull) {

            bookVm = vm.getBook();

            bookVmObjectnull = (bookVm) != (null);
            if (bookVmObjectnull) {

              bookVm.setTitle((java.lang.String) (callbackArg_0));
            }
          }
        }
      };
  private android.databinding.InverseBindingListener categoriesEdittextan =
      new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
          // Inverse of vm.book.categories
          //         is vm.book.setCategories((java.lang.String) callbackArg_0)
          java.lang.String callbackArg_0 =
              android.databinding.adapters.TextViewBindingAdapter.getTextString(categoriesEdittext);
          // localize variables for thread safety
          // vm != null
          boolean vmObjectnull = false;
          // vm.book != null
          boolean bookVmObjectnull = false;
          // vm.book.categories
          java.lang.String categoriesBookVm = null;
          // vm
          com.grayherring.kotlintest.ui.update.UpdateVM vm = mVm;
          // vm.book
          com.grayherring.kotlintest.data.modul.Book bookVm = null;

          vmObjectnull = (vm) != (null);
          if (vmObjectnull) {

            bookVm = vm.getBook();

            bookVmObjectnull = (bookVm) != (null);
            if (bookVmObjectnull) {

              bookVm.setCategories((java.lang.String) (callbackArg_0));
            }
          }
        }
      };
  private android.databinding.InverseBindingListener publisherEdittextand =
      new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
          // Inverse of vm.book.publisher
          //         is vm.book.setPublisher((java.lang.String) callbackArg_0)
          java.lang.String callbackArg_0 =
              android.databinding.adapters.TextViewBindingAdapter.getTextString(publisherEdittext);
          // localize variables for thread safety
          // vm != null
          boolean vmObjectnull = false;
          // vm.book != null
          boolean bookVmObjectnull = false;
          // vm
          com.grayherring.kotlintest.ui.update.UpdateVM vm = mVm;
          // vm.book.publisher
          java.lang.String publisherBookVm = null;
          // vm.book
          com.grayherring.kotlintest.data.modul.Book bookVm = null;

          vmObjectnull = (vm) != (null);
          if (vmObjectnull) {

            bookVm = vm.getBook();

            bookVmObjectnull = (bookVm) != (null);
            if (bookVmObjectnull) {

              bookVm.setPublisher((java.lang.String) (callbackArg_0));
            }
          }
        }
      };

  public UpdateBookBinding(
      android.databinding.DataBindingComponent bindingComponent,
      View root) {
    super(bindingComponent, root, 1);
    final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
    this.authorEdittext = (android.widget.EditText) bindings[2];
    this.authorEdittext.setTag(null);
    this.bookTitleTextEdit = (android.widget.EditText) bindings[1];
    this.bookTitleTextEdit.setTag(null);
    this.categoriesEdittext = (android.widget.EditText) bindings[4];
    this.categoriesEdittext.setTag(null);
    this.copyButton = (android.widget.Button) bindings[6];
    this.copyButton.setTag(null);
    this.publisherEdittext = (android.widget.EditText) bindings[3];
    this.publisherEdittext.setTag(null);
    this.root = (android.widget.LinearLayout) bindings[0];
    this.root.setTag(null);
    this.submitButton = (android.widget.Button) bindings[5];
    this.submitButton.setTag(null);
    setRootTag(root);
    // listeners
    mCallback2 = new android.databinding.generated.callback.OnClickListener(this, 2);
    mCallback1 = new android.databinding.generated.callback.OnClickListener(this, 1);
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
        setVm((com.grayherring.kotlintest.ui.update.UpdateVM) variable);
        return true;
    }
    return false;
  }

  public void setVm(com.grayherring.kotlintest.ui.update.UpdateVM vm) {
    //updateRegistration(0, vm);
    this.mVm = vm;
    synchronized (this) {
      mDirtyFlags |= 0x1L;
    }
    notifyPropertyChanged(1);//(BR.vm);
    super.requestRebind();
  }

  public com.grayherring.kotlintest.ui.update.UpdateVM getVm() {
    return mVm;
  }

  @Override
  protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
    switch (localFieldId) {
      case 0:
        return onChangeVm((com.grayherring.kotlintest.ui.update.UpdateVM) object, fieldId);
    }
    return false;
  }

  private boolean onChangeVm(com.grayherring.kotlintest.ui.update.UpdateVM vm, int fieldId) {
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
    java.lang.String categoriesBookVm = null;
    java.lang.String authorBookVm = null;
    java.lang.String publisherBookVm = null;
    java.lang.String titleBookVm = null;
    com.grayherring.kotlintest.data.modul.Book bookVm = null;
    boolean lockVm = false;
    com.grayherring.kotlintest.ui.update.UpdateVM vm = mVm;
    boolean logicalNotLockVm = false;

    if ((dirtyFlags & 0x3L) != 0) {

      if (vm != null) {
        // read vm.book
        bookVm = vm.getBook();
        // read vm.notifyLock
        lockVm = vm.getLock();
      }

      if (bookVm != null) {
        // read vm.book.categories
        categoriesBookVm = bookVm.getCategories();
        // read vm.book.author
        authorBookVm = bookVm.getAuthor();
        // read vm.book.publisher
        publisherBookVm = bookVm.getPublisher();
        // read vm.book.title
        titleBookVm = bookVm.getTitle();
      }
      // read !vm.notifyLock
      logicalNotLockVm = !lockVm;
    }
    // batch finished
    if ((dirtyFlags & 0x3L) != 0) {
      // api target 1

      android.databinding.adapters.TextViewBindingAdapter.setText(
          this.authorEdittext,
          authorBookVm
      );
      android.databinding.adapters.TextViewBindingAdapter.setText(
          this.bookTitleTextEdit,
          titleBookVm
      );
      android.databinding.adapters.TextViewBindingAdapter.setText(
          this.categoriesEdittext,
          categoriesBookVm
      );
      this.copyButton.setEnabled(logicalNotLockVm);
      android.databinding.adapters.TextViewBindingAdapter.setText(
          this.publisherEdittext,
          publisherBookVm
      );
      this.submitButton.setEnabled(logicalNotLockVm);
    }
    if ((dirtyFlags & 0x2L) != 0) {
      // api target 1

      android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(
          this.authorEdittext,
          (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) null,
          (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged) null,
          (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) null,
          authorEdittextandroi
      );
      android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(
          this.bookTitleTextEdit,
          (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) null,
          (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged) null,
          (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) null,
          bookTitleTextEditand
      );
      android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(
          this.categoriesEdittext,
          (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) null,
          (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged) null,
          (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) null,
          categoriesEdittextan
      );
      this.copyButton.setOnClickListener(mCallback2);
      android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(
          this.publisherEdittext,
          (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) null,
          (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged) null,
          (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) null,
          publisherEdittextand
      );
      this.submitButton.setOnClickListener(mCallback1);
    }
  }

  // Listener Stub Implementations
  // callback impls
  public final void _internalCallbackOnClick(int sourceId, android.view.View callbackArg_0) {
    switch (sourceId) {
      case 2: {
        // localize variables for thread safety
        // vm != null
        boolean vmObjectnull = false;
        // vm
        com.grayherring.kotlintest.ui.update.UpdateVM vm = mVm;

        vmObjectnull = (vm) != (null);
        if (vmObjectnull) {

          vm.copyBook();
        }
        break;
      }
      case 1: {
        // localize variables for thread safety
        // vm != null
        boolean vmObjectnull = false;
        // vm
        com.grayherring.kotlintest.ui.update.UpdateVM vm = mVm;

        vmObjectnull = (vm) != (null);
        if (vmObjectnull) {

          vm.updateBooks();
        }
        break;
      }
    }
  }

  // dirty flag
  private long mDirtyFlags = 0xffffffffffffffffL;

  public static com.grayherring.kotlintest.databinding.ActivityUpdateBookBinding inflate(
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

  public static com.grayherring.kotlintest.databinding.ActivityUpdateBookBinding inflate(
      android.view.LayoutInflater inflater,
      android.view.ViewGroup root,
      boolean attachToRoot,
      android.databinding.DataBindingComponent bindingComponent) {
    return android.databinding.DataBindingUtil.<com.grayherring.kotlintest.databinding.ActivityUpdateBookBinding>inflate(
        inflater,
        com.grayherring.kotlintest.R.layout.activity_update_book,
        root,
        attachToRoot,
        bindingComponent
    );
  }

  public static com.grayherring.kotlintest.databinding.ActivityUpdateBookBinding inflate(android.view.LayoutInflater inflater) {
    return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
  }

  public static com.grayherring.kotlintest.databinding.ActivityUpdateBookBinding inflate(
      android.view.LayoutInflater inflater,
      android.databinding.DataBindingComponent bindingComponent) {
    return bind(inflater.inflate(
        com.grayherring.kotlintest.R.layout.activity_update_book,
        null,
        false
    ), bindingComponent);
  }

  public static com.grayherring.kotlintest.databinding.ActivityUpdateBookBinding bind(android.view.View view) {
    return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
  }

  public static com.grayherring.kotlintest.databinding.ActivityUpdateBookBinding bind(
      android.view.View view,
      android.databinding.DataBindingComponent bindingComponent) {
    if (!"layout/activity_update_book_0".equals(view.getTag())) {
      throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
    }
    return new com.grayherring.kotlintest.databinding.ActivityUpdateBookBinding(bindingComponent, view);
  }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): null
    flag mapping end*/
  //end
}