package com.example.moviecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecounter.ui.theme.MovieCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCounterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /* Acción agregar película */ }) {
                            Icon(Icons.Default.Add, contentDescription = "Agregar película")
                        }
                    }
                ) { innerPadding ->
                    MovieListWithCards(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MovieCard(title: String) {
    // Componente Card para mostrar una película
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp), // aumento de padding para mejor diseño
        elevation = CardDefaults.cardElevation(6.dp) // elevación ligeramente mayor
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(20.dp) // padding interno aumentado
        )
    }
}


@Composable
fun MovieListWithCards(modifier: Modifier = Modifier) {
    // Lista de películas usando LazyColumn
    val movies = listOf("Avengers", "Batman", "Spiderman", "Iron Man", "Superman")
    LazyColumn(
        modifier = modifier.padding(8.dp) // padding externo agregado
    ) {
        items(movies.size) { index ->
            MovieCard(movies[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieListPreview() {
    MovieCounterTheme {
        MovieListWithCards()
    }
}
