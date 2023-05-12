package com.example.lesson1month8.presentation.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lesson1month8.domain.utils.Resource
import com.example.lesson1month8.presentation.ui.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment: Fragment() {
    protected fun <T> StateFlow<UIState<T>>.collectState(
        state: (UIState<T>) -> Unit,
        onSuccess: (data: T ) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                collect { result ->
                    state.invoke(result)
                    when (result) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), result.message, Toast.LENGTH_SHORT)
                                .show()
                        }

                        is UIState.Loading -> {
                            //show progress bar
                        }

                        is UIState.Success -> {
                            onSuccess(result.data)
                        }
                    }
                }
            }
        }

    }
}