@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.materialthemeviewer

//import 'package:top_app_bar_scroll_behavior/top_app_bar_scroll_behavior.dart';

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.materialthemeviewer.ui.theme.MaterialThemeViewerTheme
import androidx.compose.material3.TopAppBarDefaults as Material3TopAppBarDefaults
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
<<<<<<< HEAD
import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.material3.Divider
//import androidx.compose.material3.DropdownMenu
//import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
=======
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
>>>>>>> parent of 626a15f (surface tonal elecavation help PC laggy)

class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    setContent {
        layout()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    layout()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun layout(){
    MaterialThemeViewerTheme {
        val decayAnimationSpec = rememberSplineBasedDecay<Float>()
        val scrollBehavior = remember(decayAnimationSpec) {
            Material3TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
        }
        //val scrollBehavior = remember { Material3TopAppBarDefaults.pinnedScrollBehavior() }
        val topAppBarElementColor = MaterialTheme.colorScheme.onSurface

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                LargeTopAppBar(
                    colors = Material3TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        scrolledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                        navigationIconContentColor = topAppBarElementColor,
                        titleContentColor = topAppBarElementColor,
                        actionIconContentColor= topAppBarElementColor,
                    ),
                    title = {
                        Text(
                            "Material Palette",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    scrollBehavior=scrollBehavior,
                    //scrollBehavior: TopAppScrollBarBehavior
                )
            },

        ){
            LazyColumn{
                item {
                    Primary("Primary")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Secondary("Secondary")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Tertiary("Tertiary")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Surface("Surface")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Error("Error")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Background("Background")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                /*item{
                    ElevationPicker()
                }*/
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

val chipHeight=98.dp
val chipScale=16.dp
var elevation = 0.dp
/*
Tonal Elevation values
level 0= 0.dp
level 1= 1.dp
level 2= 3.dp
level 3= 6.dp
level 4= 8.dp
level 5= 12.dp
 */


/*@Composable
fun ElevationPicker(){
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Edit") },
                onClick = { /* Handle edit! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null
                    )
                })
            DropdownMenuItem(
                text = { Text("Settings") },
                onClick = { /* Handle settings! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Settings,
                        contentDescription = null
                    )
                })
            Divider()
            DropdownMenuItem(
                text = { Text("Send Feedback") },
                onClick = { /* Handle send feedback! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Email,
                        contentDescription = null
                    )
                },
                trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
        }
    }
}*/

//Primary color block
@Composable
fun Primary(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current

    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.primary,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Primary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onPrimary,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Primary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.primaryContainer,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Primary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Primary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                )
            }
        }
    }
}

//secondary color block
@Composable
fun Secondary(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.secondary,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Secondary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onSecondary,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Secondary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.secondaryContainer,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Secondary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Secondary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
            }
        }
    }
}

//tertiary color block
@Composable
fun Tertiary(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.tertiary,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Tertiary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onTertiary,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Tertiary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.tertiaryContainer,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Tertiary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Tertiary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.tertiaryContainer
                )
            }
        }
    }
}
//error color block
@Composable
fun Error(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.error,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Error",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onError
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onError,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Error",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.errorContainer,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Error Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onErrorContainer,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Error Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.errorContainer
                )
            }
        }
    }
}

//surface color block
@Composable
fun Surface(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
<<<<<<< HEAD
                color = MaterialTheme.colorScheme.surface,
                tonalElevation= elevation,
=======
                color = MaterialTheme.colorScheme.surface
>>>>>>> parent of 626a15f (surface tonal elecavation help PC laggy)
            ) {
                Text(
                    text = "Surface",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onSurface,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Surface",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.surfaceVariant,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Surface Variant",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Surface Variant",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
    }
}

//background color block
@Composable
fun Background(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.background,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Background",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onBackground,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "on Background",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast
                            .makeText(context, "Material You Colors!", Toast.LENGTH_SHORT)
                            .show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.outline,
                tonalElevation= elevation,
            ) {
                Text(
                    text = "Outline",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }
    }
}