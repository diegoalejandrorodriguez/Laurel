package edu.co.javeriana.tais2020.laurel.ui.menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.co.javeriana.tais2020.laurel.R

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val adapter = MenuItemsAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setMenuItems(listOf(
            MenuItem(1, "Inicio", "ic_outline_home_24dp", 0),
            MenuItem(2, "Buscar", "ic_outline_loupe_24dp", 0),
            MenuItem(3, "Notificaciones", "ic_outline_notifications_24dp", 1),
            MenuItem(4, "Mis compras", "ic_outline_shopping_bag_24dp", 0),
            MenuItem(5, "Mi cuenta", "ic_outline_account_circle_24dp", 0),
            MenuItem(6, "Vender", "ic_outline_price_tags_24dp", 0)
        ))

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}