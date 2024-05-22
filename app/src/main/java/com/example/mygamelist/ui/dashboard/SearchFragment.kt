package com.example.mygamelist.ui.dashboard

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mygamelist.R
import com.example.mygamelist.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        searchViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        // Obtener referencia al SearchView
        val searchView: SearchView = root.findViewById(R.id.busqueda)

        // Cambiar el ícono de búsqueda a blanco
        val searchIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_button)
        searchIcon.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.icon_search))

        // Aplicar el ColorFilter al ícono de búsqueda
        searchIcon.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.white), PorterDuff.Mode.SRC_IN)

        //cambiar el color de la x de cerrar
        val closeIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        closeIcon.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.white), PorterDuff.Mode.SRC_IN)

        // Cambiar el color del hint y el texto usando el color definido en colors.xml
        val searchEditText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        val hintColor = ContextCompat.getColor(requireContext(), R.color.gris_claro)
        searchEditText.setHintTextColor(hintColor)
        searchEditText.setTextColor(hintColor)

        // Cambiar el tamaño del texto
        searchEditText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)

        // Asegurarse de que el texto esté centrado verticalmente
        searchEditText.setPadding(40, 0, 0, 0) // Ajusta el padding según sea necesario
        searchEditText.gravity = android.view.Gravity.CENTER_VERTICAL

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}